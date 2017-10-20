package cn.xhu.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xhu.dao.cache.RedisDao;
import cn.xhu.entity.Seckill;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-config.xml"})
public class RedisTest {
	
	@Autowired
	private RedisDao redisDao;
	@Autowired
	private ISeckillDao iSeckillDao;
	
	@Test
	public void Test() throws Exception{
		long seckillId = 1002;
		Seckill seckill = redisDao.getSeckill(seckillId);
		if(seckill == null){
			seckill = iSeckillDao.queryById(seckillId);
			if(seckill!=null){
				String rusult = redisDao.putSeckill(seckill);
				System.out.println(rusult);
				seckill = redisDao.getSeckill(seckillId);
				System.out.println(seckill);
			}
		}
		System.out.println(seckill);
	}
	
	
}
