package cn.xhu.enums;
/**
 * 使用枚举列出使用的常量数据字典
 * @author Administrator
 *
 */
public enum SeckillBaseEnum {
	SUCCESS(1,"秒杀成功"),
	END(0,"秒杀结束"),
	REPEAT_KILL(-1,"重复秒杀"),
	INNER_ERROR(-2,"系统异常"),
	RE_WRITE(-3,"数据篡改");
	private int state;
	private String stateInfo;
	private SeckillBaseEnum(int state, String stateInfo) {
		this.state = state;
		this.stateInfo = stateInfo;
	}
	public int getState() {
		return state;
	}
	public String getStateInfo() {
		return stateInfo;
	}
	
	public static SeckillBaseEnum stateOf(int index){
		for(SeckillBaseEnum state : values()){
			if(state.getState() == index){
				return state;
			}
		}
		return null;
	}
	
}
