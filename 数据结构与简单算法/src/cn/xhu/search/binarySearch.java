package cn.xhu.search;
/**
 * ���ֲ���
 * @author Administrator
 *
 */
public class binarySearch {
	/**
	 * ʹ�õݹ�ʵ���۰����
	 * ʱ�临�Ӷȣ�T(n) = T(n/2)  O(logn)
	 * @param arr
	 * @param key
	 * @param begin
	 * @param end
	 * @return
	 */
	public static int binary_search(int[] arr,int key,int begin,int end){
		if(begin>=end){
			return -1;
		}
		int mid = (begin+end)/2;
		if(arr[mid]<key){
			return binary_search(arr, key, mid+1, end);
		}
		else if(arr[mid]>key){
			return binary_search(arr, key, begin, mid-1);
		}else{
			return mid;
		}
	}
	/**
	 * �ǵݹ�ʵ���۰����
	 * @param arr
	 * @param key
	 * @param begin
	 * @param end
	 * @return
	 */
	public static int binary_search_iterate(int[] arr,int key,int begin,int end){
		while(begin<end){
			int mid = (begin+end)/2;
			if(arr[mid]<key){
				begin = mid + 1;
			}
			else if(arr[mid]>key){
				end = mid - 1;
			}else{
				return mid;
			}
		}
		return -1;	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {2,3,4,6,7,9};
		System.out.println(binary_search(arr, 7, 0, 5));
		System.out.println(binary_search_iterate(arr, 3, 0, 5));
	}

}
