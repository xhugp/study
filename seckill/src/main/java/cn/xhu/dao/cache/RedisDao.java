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
 * redis实现秒杀接口缓存
 * @author Administrator
 *
 */
public class RedisDao {
	//日志
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	//jedis客户端连接池
	private final JedisPool jedisPool;
	//序列化
	private RuntimeSchema<Seckill> schema = RuntimeSchema.createFrom(Seckill.class);
	
	public RedisDao(String ip,int port){
		jedisPool = new JedisPool(ip,port);
	}
	public Seckill getSeckill(long seckillId){
		try {
			//得到jedis连接
			Jedis jedis = jedisPool.getResource();
			try {
				String key = "seckillId:" + seckillId;
				byte[] data = jedis.get(key.getBytes());
				if (data != null) {
					//缓存中存在该对象数据
					//使用schema建立一个空对象
					Seckill seckill = schema.newMessage();
					//取出缓存中的值反序列化 为空对象赋值
					ProtobufIOUtil.mergeFrom(data, seckill, schema);
					// 返回取出的seckill对象
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
				//设置超时
				int seconds = 60*60;//一天
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
