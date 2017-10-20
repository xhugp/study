package cn.xhu.sort;
/**
 * 快速排序
 * @author Administrator
 *
 */
public class QuiteSort {
	public static void swap(int a,int b){
		int temp = a;
		a = b;
		b = temp;
		System.out.println(a+" "+b);
	}
	/**
	 * 快速排序1
	 * @param arr
	 * @param begin
	 * @param end
	 */
	public static void Sort1(int[] arr,int begin,int end){
		if(begin>=end){
			return;
		}
		int left = begin;
		int right = end;
		int value = arr[left];//将第一个数设为轴心，并保存它的值
		//时间复杂度O(nlogn)    T(n) = O(n) + 2T(n/2)   主定律计算得O(nlogn)
		while(left<right){
			if(value>arr[left+1]){
				arr[left] = arr[left+1];
				left++;
			}else{				
				int temp = arr[right];
				arr[right] = arr[left+1];
				arr[left+1] = temp;
				right--;
			}	
		}		
		arr[left] = value;
		Sort1(arr,begin,left-1);
		Sort1(arr,left+1,end);
	}
	
	/**
	 * 快速排序2
	 * @param arr
	 * @param begin
	 * @param end
	 */
	public static void Sort2(int[] arr,int begin,int end){
		if(begin>=end){
			return;
		}
		int value = arr[begin];
		int index = begin;//将第一个数定位基准，得到该数的下标
		//时间复杂度O(nlogn)
		for(int k = begin+1;k<=end;k++){
			if(arr[k]<value){
				arr[k] = arr[k] + arr[index];
				arr[index] = arr[k] - arr[index];
				arr[k] = arr[k] - arr[index];				
				index++;
			}
		}
		Sort2(arr,begin,index-1);
		Sort2(arr,index+1,end);		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {5,9,2,4,7,6,6};
		Sort1(arr, 0, 6);
		for(int i = 0;i<7;i++){
			System.out.print(arr[i]+" ");
		}			
	}

}
