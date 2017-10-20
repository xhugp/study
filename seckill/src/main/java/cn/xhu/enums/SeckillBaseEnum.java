package cn.xhu.enums;
/**
 * ʹ��ö���г�ʹ�õĳ��������ֵ�
 * @author Administrator
 *
 */
public enum SeckillBaseEnum {
	SUCCESS(1,"��ɱ�ɹ�"),
	END(0,"��ɱ����"),
	REPEAT_KILL(-1,"�ظ���ɱ"),
	INNER_ERROR(-2,"ϵͳ�쳣"),
	RE_WRITE(-3,"���ݴ۸�");
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
