package cn.xhu.list;

public class test1 {
	public static void main(String[] args) {
		int[] mm = {5,6,3,4,12,7,11,4};
		Revers(mm);		
		//Ajust(mm);	
		for (int i : mm) {
			System.out.print(i+" ");
		}
		
	}

	/**
	 * ��һ�������Ϊ���������֣������Ϊ�������ұ�Ϊż��
	 * @param par
	 */
	static void Ajust(int[] par){
		int i = 0;
		int j = par.length - 1;
		while(i<j){
			while(par[i]%2!=0){
				i++;
			}
			while(par[j]%2==0){
				j--;
			}
			if(i<j){
				int m =par[i];
				par[i] = par[j];
				par[j] = m;
			}
		}
	}
	/**
	 * ʵ�־͵ص��ã���������ĵ������
	 * @param par
	 */
	static void Revers(int[] par){
		int i = 0;
		int j = par.length - 1;
		while(i<j){
			int m =par[i];
			par[i] = par[j];
			par[j] = m;
			i++;
			j--;
		}
	}
}
