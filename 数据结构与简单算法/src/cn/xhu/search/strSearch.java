package cn.xhu.search;

public class strSearch {
	/**
	 * һ���㷨��ȫ�������Ƚ�,ʱ�临�Ӷ�O(mn);
	 * @param base �����ַ���
	 * @param str ���ҵ��ַ���
	 * @return Ҫ�����ַ�����һ�γ��ֵ�λ��
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
