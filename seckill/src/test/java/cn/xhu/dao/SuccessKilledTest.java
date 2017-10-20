package cn.xhu.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xhu.dao.ISuccessKilledDao;
import cn.xhu.entity.SuccessKilled;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-config.xml"})
public class SuccessKilledTest {
	
	@Resource
	private ISuccessKilledDao isk; 

	@Test
	public void insertSuccessKilled(){
		int count = isk.insertSuccessKilled(1001L, 13980069479L);
		System.out.println("≤Â»Î ˝¡ø£∫"+count);
	}
	
	@Test
	public void queryById(){
		List<SuccessKilled> successKilleds= isk.queryById(1001L);
		for (SuccessKilled successKilled : successKilleds) {
			System.out.println(successKilled);
		}
	}

	@Test
	public void queryByIdAndPhone(){
		SuccessKilled successKilled =  isk.queryByIdAndPhone(1000L, 13980069479L);
		System.out.println(successKilled);
		System.out.println(successKilled.getSeckill());
	}
	
}
