package cn.xhu.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import cn.xhu.dao.ISeckillDao;
import cn.xhu.dao.ISuccessKilledDao;
import cn.xhu.dao.cache.RedisDao;
import cn.xhu.dto.Exposer;
import cn.xhu.dto.SeckillExecution;
import cn.xhu.entity.Seckill;
import cn.xhu.entity.SuccessKilled;
import cn.xhu.enums.SeckillBaseEnum;
import cn.xhu.exception.RepeatKillException;
import cn.xhu.exception.SeckillCloseException;
import cn.xhu.exception.SeckillException;
import cn.xhu.service.SeckillService;

/**
 * @Component �κ�����
 * @Controller ���Ʋ�
 * @Service �����
 * @Dao dao��
 */
@Service
public class SeckillServiceImpl implements SeckillService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	// ʹ��@Autowiredע���Զ�ע������
	@Autowired
	private ISeckillDao iSeckillDao;
	@Autowired
	private ISuccessKilledDao iSuccessKilledDao;
	@Autowired
	private RedisDao redisDao;
	// ����һ���ַ�������֮������md5�ַ���
	private final String salt = "cascuywecjhyuegwf61cwe15113ed";

	public List<Seckill> getSeckillList() {
		// TODO Auto-generated method stub
		return iSeckillDao.queryAll(0, 5);
	}

	public Seckill getById(long seckillId) {
		// TODO Auto-generated method stub
		return iSeckillDao.queryById(seckillId);
	}

	public Exposer exportSeckillUrl(long seckillId) {
		// TODO Auto-generated method stub
		Seckill seckill = redisDao.getSeckill(seckillId);
		if (seckill == null) {
			seckill = iSeckillDao.queryById(seckillId);
			if (seckill == null) {
				return new Exposer(false, seckillId);
			} else {
				redisDao.putSeckill(seckill);
			}
		}
		Date startTime = seckill.getStartTime();
		Date endTime = seckill.getEndTime();
		Date nowTime = new Date();
		if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
			return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
		}
		// ת���ض��ַ����Ĺ��̣�������
		String md5 = getMD5(seckillId);
		return new Exposer(true, md5, seckillId);
	}

	/**
	 * ʹ��ע���������������
	 */
	@Transactional
	public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5)
			throws SeckillCloseException, RepeatKillException, SeckillException {
		// TODO Auto-generated method stub
		if (md5 == null || !getMD5(seckillId).equals(md5)) {
			throw new SeckillException("seckill data rewrite");
		}
		/*
		 * ִ����ɱ����������¼��ɱ��¼
		 */
		Date nowtime = new Date();
		try {
			// �����
			int seckillCount = iSeckillDao.reduceNumber(seckillId, nowtime);
			if (seckillCount <= 0) {
				throw new SeckillCloseException("seckill is closed");
			} else {
				// ��¼������Ϊ
				int insertCount = iSuccessKilledDao.insertSuccessKilled(seckillId, userPhone);
				if (insertCount <= 0) {
					throw new RepeatKillException("seckill repeat");
				} else {
					SuccessKilled successKilled = iSuccessKilledDao.queryByIdAndPhone(seckillId, userPhone);
					return new SeckillExecution(seckillId, SeckillBaseEnum.SUCCESS, successKilled);
				}
			}
		} catch (SeckillCloseException s1) {
			throw s1;
		} catch (RepeatKillException s2) {
			throw s2;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error(e.getMessage(), e);
			// ���������쳣ת��Ϊ�������쳣
			throw new SeckillException("seckill inner error" + e.getMessage());
		}
	}

	private String getMD5(long seckillId) {
		String base = seckillId + "/" + salt;
		String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
		return md5;
	}
}
