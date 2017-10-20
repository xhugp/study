package cn.xhu.dao.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtobufIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;

import cn.xhu.entity.Seckill;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * redisʵ����ɱ�ӿڻ���
 * @author Administrator
 *
 */
public class RedisDao {
	//��־
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	//jedis�ͻ������ӳ�
	private final JedisPool jedisPool;
	//���л�
	private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);
	
	public RedisDao(String ip,int port){
		jedisPool = new JedisPool(ip,port);
	}
	public Seckill getSeckill(long seckillId){
		try {
			//�õ�jedis����
			Jedis jedis = jedisPool.getResource();
			try {
				String key = "seckillId:" + seckillId;
				byte[] data = jedis.get(key.getBytes());
				if (data != null) {
					//�����д��ڸö�������
					//ʹ��schema����һ���ն���
					Seckill seckill = schema.newMessage();
					//ȡ�������е�ֵ�����л� Ϊ�ն���ֵ
					ProtobufIOUtil.mergeFrom(data, seckill, schema);
					// ����ȡ����seckill����
					return seckill;
				} 
			} finally {
				jedis.close();
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());
		}		
		return null;
	}
	
	public String putSeckill(Seckill seckill){
		
		try {
			Jedis jedis = jedisPool.getResource();
			try {				
				String key = "seckillId:" + seckill.getSeckillId();
				byte[] data = ProtobufIOUtil.toByteArray(seckill, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
				//���ó�ʱ
				int seconds = 60*60;//һ��
				String result = jedis.setex(key.getBytes(), seconds, data);
				return result;
			} finally {
				jedis.close();
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage());	
		}
		return null;
	}
}
