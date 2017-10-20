package cn.xhu.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.xhu.entity.Seckill;

public interface ISeckillDao {
	/**
	 * 减库存
	 * @param seckillId 商品ID
	 * @param createtime 创建时间
	 * @return 影响的行数 
	 */
	/**
	 * iSeckillDao.queryAll(int offset,int limit) 被java解析后变为(arg0,arg1),
	 * 以至于mybatis的sql语句无法匹配到参数，
	 * 可以在参数前使用@param注解的方式告诉mybatis两个参数
	 * queryAll(@Param("offset") int offset,@Param("limit") int limit)
	 */
	int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime);
	/**
	 * 查询秒杀商品信息 
	 * @param seckillId 商品ID
	 * @return 返回一个Seckill对象
	 */
	Seckill queryById(long seckillId);
	/**
	 * 批量查询
	 * @param offest 偏移量
	 * @param limit 查询的记录条数
	 * @return Seckill对象集合
	 */
	List<Seckill> queryAll(@Param("offset") int offset,@Param("limit") int limit);
}
