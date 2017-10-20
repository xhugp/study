package cn.xhu.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xhu.dao.ISeckillDao;
import cn.xhu.entity.Seckill;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-config.xml"})
public class SeckillTest {
	@Resource
	private ISeckillDao iSeckillDao;
	
	@Test
	public void queryById(){
		Long id = (long) 1000;
		Seckill seckill= iSeckillDao.queryById(id);
		System.out.println(seckill.getName());
		System.out.println(seckill);	
	}
	/**
	 * iSeckillDao.queryAll(int offset,int limit) 被java解析后变为(arg0,arg1),
	 * 以至于mybatis的sql语句无法匹配到参数，
	 * 可以在参数前使用@param注解的方式告诉mybatis两个参数
	 * queryAll(@Param("offset") int offset,@Param("limit") int limit)
	 */
	@Test
	public void queryAllTest(){
		List<Seckill> seckills= iSeckillDao.queryAll(0,5);
		for (Seckill seckill : seckills) {
			System.out.println(seckill);
		}
	}
	
	@Test
	public void reduceTest(){
		Date killtime = new Date();
		int count = iSeckillDao.reduceNumber(1000L, killtime);
		System.out.println("秒杀数量："+count);
	}
}
