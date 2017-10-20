package cn.xhu.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.xhu.entity.Seckill;

public interface ISeckillDao {
	/**
	 * �����
	 * @param seckillId ��ƷID
	 * @param createtime ����ʱ��
	 * @return Ӱ������� 
	 */
	/**
	 * iSeckillDao.queryAll(int offset,int limit) ��java�������Ϊ(arg0,arg1),
	 * ������mybatis��sql����޷�ƥ�䵽������
	 * �����ڲ���ǰʹ��@paramע��ķ�ʽ����mybatis��������
	 * queryAll(@Param("offset") int offset,@Param("limit") int limit)
	 */
	int reduceNumber(@Param("seckillId") long seckillId,@Param("killTime") Date killTime);
	/**
	 * ��ѯ��ɱ��Ʒ��Ϣ 
	 * @param seckillId ��ƷID
	 * @return ����һ��Seckill����
	 */
	Seckill queryById(long seckillId);
	/**
	 * ������ѯ
	 * @param offest ƫ����
	 * @param limit ��ѯ�ļ�¼����
	 * @return Seckill���󼯺�
	 */
	List<Seckill> queryAll(@Param("offset") int offset,@Param("limit") int limit);
}
