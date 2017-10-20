package cn.xhu.work;
/**
 * 找两个数的最大公约数
 * @author Administrator
 *
 */
public class work1 {
	/**
	 * 辗转相除法
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
		int yu = max%min;//取余		
		if(yu==0){// 如果余数为0；返回最小数即为最大公约数
			return min;
		}
		else{//否则递归，将余数和最小数作为参数
			return scd(yu,min);
		}		
	}
	/**
	 * 使用进制实现求解最大公约数
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
		if((a&1)==0){//a为偶数
			if((b&1)==1){//b为奇数。a为偶，b为奇
				return scd2(a>>1,b);
			}else{//a为偶，b为偶
				return scd2(a>>1,b>>1)<<1;
			}
		}
		if((b&1)==0){//b为偶数
			return scd2(a,b>>1);
		}
		//相减法
		if(a>b){//a，b都为奇数，且a>b
			return scd((a-b)>>1,b);
		}
		//a，b都为奇数，且a<b
		return scd((b-a)>>1,a);
	}
	
	public static void main(String[] args) {
		int a = 5,b = 35;	
		System.out.println(scd2(a, b));
	}
}
