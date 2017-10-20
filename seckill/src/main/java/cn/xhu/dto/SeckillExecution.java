package cn.xhu.dto;

import cn.xhu.entity.SuccessKilled;
import cn.xhu.enums.SeckillBaseEnum;

/**
 * ��װ��ɱ���
 * @author Administrator
 *
 */
public class SeckillExecution {
	//��ɱID
	private long seckillId;
	//��ɱ״̬
	private int state;
	//״̬��Ϣ
	private String stateInfo;
	//��ɱ���鵥
	private SuccessKilled successKilled;
	
	
	
	public SeckillExecution() {
		super();
	}


	public SeckillExecution(long seckillId, SeckillBaseEnum seckillBaseEnum, SuccessKilled successKilled) {
		super();
		this.seckillId = seckillId;
		this.state = seckillBaseEnum.getState();
		this.stateInfo = seckillBaseEnum.getStateInfo();
		this.successKilled = successKilled;
	}
	
	
	public SeckillExecution(long seckillId, SeckillBaseEnum seckillBaseEnum) {
		super();
		this.seckillId = seckillId;
		this.state = seckillBaseEnum.getState();
		this.stateInfo = seckillBaseEnum.getStateInfo();
	}


	public long getSeckillId() {
		return seckillId;
	}
	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getStateInfo() {
		return stateInfo;
	}
	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}
	public SuccessKilled getSeccessKilled() {
		return successKilled;
	}
	public void setSeccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}


	@Override
	public String toString() {
		return "SeckillExecution [seckillId=" + seckillId + ", state=" + state + ", stateInfo=" + stateInfo
				+ ", successKilled=" + successKilled + "]";
	}
	
	
}
