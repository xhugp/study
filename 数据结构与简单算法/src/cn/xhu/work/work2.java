package cn.xhu.work;

import java.util.Scanner;
/**
 * 
 * @author Administrator
 *
 */
public class work2 {
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String ss = sc.nextLine();
		System.out.println(check(ss));
		sc.close();
	}

	private static boolean check(String ss) {
		// TODO Auto-generated method stub
		char[] arry = ss.toCharArray();
		int[] a = new int[arry.length/2];;//a为偶
		int[] b; //b为奇数数组
		if(ss.length()%2==0){
			 b = new int[arry.length/2];
		}else{
			b = new int[arry.length/2+1];
		}
		
		//将输入的数字拆分
		int m=0;
		int n = 0;
		for(int i = 0;i<arry.length;i++){		
			if((i+1)%2==0){
				if(arry[i]*2>=10){
					a[m++] = arry[i]*2-9;
				}else{
					a[m++] = arry[i];
				}
			}else{
				b[n++]=arry[i];
			}
		}
		int sum=0;
		sum=Sum(b)+Sum(a);
		if(sum%10==0){
			return true;
		}
		return false;
	}
	
	private static int Sum(int[] arr){
		int s=0;
		for(int i = 0;i<arr.length;i++){
			s+=arr[i];
		}
		return s;
	}

}
