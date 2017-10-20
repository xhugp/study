package cn.xhu.search;

public class sumSearch {
	/**
	 * 如果数组未排序，此方法时间复杂度O(nlogn)
	 * @param arr
	 * @param value
	 */
	public static void two_sum1(int[] arr,int value){
		for(int i=0;i<arr.length;i++){
			for(int j = i+1;j<arr.length;j++){
				if(arr[i]+arr[j]==value){
					System.out.println(arr[i]+","+arr[j]);
				}
			}
		}
	}
	/**
	 * 如果数组已经排序，此方法时间复杂度O(n)
	 * @param arr
	 * @param value
	 */
	public static void two_sum2(int[] arr,int value){
		int left = 0;
		int right = arr.length-1;
		while(left<right){
			if(arr[left]+arr[right]>value){
				right--;
			}
			else if(arr[left]+arr[right]<value){
				left++;
			}
			else{
				System.out.println(arr[left]+","+arr[right]);
				left++;
				right--;
			}
		}		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1={8,1,7,4,9,5,6,2,0,3};
		int[] arr2={0,1,2,3,4,5,6,7,8,9};
		two_sum1(arr1, 9);
		System.out.println("===========");
		
		two_sum2(arr2, 9);
		
	}

}
