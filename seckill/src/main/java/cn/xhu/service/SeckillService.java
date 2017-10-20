package cn.xhu.service;

import java.util.List;

import cn.xhu.dto.Exposer;
import cn.xhu.dto.SeckillExecution;
import cn.xhu.entity.Seckill;
import cn.xhu.exception.RepeatKillException;
import cn.xhu.exception.SeckillCloseException;
import cn.xhu.exception.SeckillException;

/**
 * 业务接口：站在“使用者”的角度设计接口
 * 三个方面：方法定义密度（方法明确），参数（越简单越少越好），返回类型（return/异常）
 * @author Administrator
 *
 */
public interface SeckillService {
	/**
	 * 展示秒杀产品列表
	 * @return
	 */
	List<Seckill> getSeckillList();
	/**
	 * 根据id查询秒杀商品
	 * @param seckillId
	 * @return
	 */
	Seckill getById(long seckillId);
	/**
	 * 秒杀开启时输出秒杀接口地址
	 * 否则输出系统时间和秒杀时间
	 * @param seckillId
	 */
	Exposer exportSeckillUrl(long seckillId);
	/**
	 * 执行秒杀操作
	 * @param seckillId	秒杀的ID
	 * @param userPhone	用户的电话
	 * @param md5 加密后的数据
	 */
	SeckillExecution executeSeckill(long seckillId,long userPhone,String md5)
			throws SeckillCloseException,RepeatKillException,SeckillException;
}
