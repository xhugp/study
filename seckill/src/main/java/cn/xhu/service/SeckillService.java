package cn.xhu.service;

import java.util.List;

import cn.xhu.dto.Exposer;
import cn.xhu.dto.SeckillExecution;
import cn.xhu.entity.Seckill;
import cn.xhu.exception.RepeatKillException;
import cn.xhu.exception.SeckillCloseException;
import cn.xhu.exception.SeckillException;

/**
 * ҵ��ӿڣ�վ�ڡ�ʹ���ߡ��ĽǶ���ƽӿ�
 * �������棺���������ܶȣ�������ȷ����������Խ��Խ��Խ�ã����������ͣ�return/�쳣��
 * @author Administrator
 *
 */
public interface SeckillService {
	/**
	 * չʾ��ɱ��Ʒ�б�
	 * @return
	 */
	List<Seckill> getSeckillList();
	/**
	 * ����id��ѯ��ɱ��Ʒ
	 * @param seckillId
	 * @return
	 */
	Seckill getById(long seckillId);
	/**
	 * ��ɱ����ʱ�����ɱ�ӿڵ�ַ
	 * �������ϵͳʱ�����ɱʱ��
	 * @param seckillId
	 */
	Exposer exportSeckillUrl(long seckillId);
	/**
	 * ִ����ɱ����
	 * @param seckillId	��ɱ��ID
	 * @param userPhone	�û��ĵ绰
	 * @param md5 ���ܺ������
	 */
	SeckillExecution executeSeckill(long seckillId,long userPhone,String md5)
			throws SeckillCloseException,RepeatKillException,SeckillException;
}
