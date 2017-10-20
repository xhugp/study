package cn.xhu.search;

public class strSearch {
	/**
	 * 一般算法，全部遍历比较,时间复杂度O(mn);
	 * @param base 基础字符串
	 * @param str 查找的字符串
	 * @return 要查找字符串第一次出现的位置
	 */
	public static int strStr(String base,String str){
		for(int i=0;i<base.length()-str.length();i++){
			int count = 0;
			while(count<str.length()){
				if(str.charAt(count)==base.charAt(i+count)){
					count++;
				}else{
					break;
				}
			}
			if(count==str.length()){
				return i;
			}			
		}		
		return -1;		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String base = "abdgajnceubwy";
		String str = "jnc";
		System.out.println(strStr(base, str));
		
	}

}
