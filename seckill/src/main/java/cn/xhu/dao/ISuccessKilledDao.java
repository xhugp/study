package cn.xhu.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.xhu.entity.SuccessKilled;

public interface ISuccessKilledDao {
	/**
	 *  ������ɱ����
	 * @param seckillId ��Ʒid
	 * @param userPhone �û��绰����
	 * @return Ӱ������� 
	 */
	int insertSuccessKilled(@Param("seckillId") long seckillId,@Param("userPhone")long userPhone);
	/**
	 * ������Ʒid��ѯ��ɱ����
	 * @param seckillId ��ƷId
	 * @return ��ɱ����Ʒ�������¼����
	 */
	List<SuccessKilled> queryById(long seckillId);	
	/**
	 * ������ƷID���û��绰��ѯ��ɱ����
	 * @param ��ƷID
	 * @param �û��绰
	 * @return ��ɱ�������
	 */
	SuccessKilled queryByIdAndPhone(@Param("seckillId") long seckillId,@Param("userPhone")long userPhone);
}
