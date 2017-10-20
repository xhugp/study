package cn.xhu.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.xhu.dto.Exposer;
import cn.xhu.dto.SeckillExecution;
import cn.xhu.entity.Seckill;
import cn.xhu.exception.RepeatKillException;
import cn.xhu.exception.SeckillCloseException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
		"classpath:spring/spring-config.xml",
		"classpath:spring/spring-service.xml"})
public class ServiceTest {
	//使用slf4j管理日志输出
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SeckillService seckillService;
		
		
	@Test
	public void getSeckillListTest(){
		List<Seckill> list = seckillService.getSeckillList();
		logger.info("list={}", list);
	}
	@Test
	public void getByIdTest(){
		long id = 1000;
		Seckill seckill = seckillService.getById(id);
		logger.info("seckill={}", seckill);
	}
	/**
	 * md5=0a26f667d22654dffa5450578bbafd6a
	 */
	@Test
	public void seckillLogicTest() throws Exception{
		long id = 1004L;
		Exposer exposer = seckillService.exportSeckillUrl(id);
		if(exposer.isExposed()){
			System.out.println(exposer);
			long userPhone = 13980069479L;
			String md5 = exposer.getMd5();
			try{
				SeckillExecution se=seckillService.executeSeckill(id, userPhone, md5);
				logger.info("SeckillExecution={}", se);
			}catch(RepeatKillException r){
				logger.error(r.getMessage());
			}catch(SeckillCloseException sc){
				logger.error(sc.getMessage());
			}
		}else{
			logger.warn("秒杀未开启");
		}
	}

}
