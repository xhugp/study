package cn.xhu.work;
/**
 * �������������Լ��
 * @author Administrator
 *
 */
public class work1 {
	/**
	 * շת�����
	 * @param a
	 * @param b
	 * @return
	 */
	public static int scd(int a,int b){
		if(a==0||b==0){
			return a==0?b:a;
		}
		int max = a>b?a:b;
		int min = a<b?a:b;
		int yu = max%min;//ȡ��		
		if(yu==0){// �������Ϊ0��������С����Ϊ���Լ��
			return min;
		}
		else{//����ݹ飬����������С����Ϊ����
			return scd(yu,min);
		}		
	}
	/**
	 * ʹ�ý���ʵ��������Լ��
	 * @param a
	 * @param b
	 * @return
	 */
	public static int scd2(int a,int b){
		if(a==b){
			return a;
		}
		if(a==0){
			return b;
		}
		if(b==0){
			return a;
		}
		if((a&1)==0){//aΪż��
			if((b&1)==1){//bΪ������aΪż��bΪ��
				return scd2(a>>1,b);
			}else{//aΪż��bΪż
				return scd2(a>>1,b>>1)<<1;
			}
		}
		if((b&1)==0){//bΪż��
			return scd2(a,b>>1);
		}
		//�����
		if(a>b){//a��b��Ϊ��������a>b
			return scd((a-b)>>1,b);
		}
		//a��b��Ϊ��������a<b
		return scd((b-a)>>1,a);
	}
	
	public static void main(String[] args) {
		int a = 5,b = 35;	
		System.out.println(scd2(a, b));
	}
}
