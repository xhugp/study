package cn.xhu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.xhu.entity.SuccessKilled;

public interface ISuccessKilledDao {
	/**
	 *  插入秒杀详情
	 * @param seckillId 商品id
	 * @param userPhone 用户电话号码
	 * @return 影响的行数 
	 */
	int insertSuccessKilled(@Param("seckillId") long seckillId,@Param("userPhone")long userPhone);
	/**
	 * 根据商品id查询秒杀详情
	 * @param seckillId 商品Id
	 * @return 秒杀该商品的详情记录集合
	 */
	List<SuccessKilled> queryById(long seckillId);	
	/**
	 * 根据商品ID和用户电话查询秒杀详情
	 * @param 商品ID
	 * @param 用户电话
	 * @return 秒杀详情对象
	 */
	SuccessKilled queryByIdAndPhone(@Param("seckillId") long seckillId,@Param("userPhone")long userPhone);
}
