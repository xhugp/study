package cn.xhu.work;

import java.util.Scanner;

public class work3 {
	    public static void main(String[] args) {  
	        int count;// ��ʾ���ϵ��ܺ�  
	        String in;  
	        Integer[] julis;  
	        Scanner scanner = new Scanner(System.in);  
	        count = scanner.nextInt();  
	        scanner.nextLine();  
	        julis = new Integer[count];// ����װ�ؾ����ÿֻ���ϵľ���  
	        boolean[] isGanMao = new boolean[count];// ÿֻ�����Ƿ��ð�ľ�������  
	        in = scanner.nextLine();  
	        long start = System.currentTimeMillis();  
	        String[] strings = in.split(" ");  
	        for (int i = 0; i < count; i++) {  
	            julis[i] = new Integer(strings[i]);  
	            isGanMao[i] = false;  
	        }// �����������  
	        isGanMao[0] = true;  
	        print(calculate(count, julis, isGanMao)+1);//��Ⱦ���������ϵ������͵�һ�����������  
	        long end = System.currentTimeMillis();  
	        print("�˳�������,���ѵ�ʱ����" + ((end - start) / 1000.0) + "��.");  
	    }  
	  
	    public static int calculate(int count, Integer[] julis, boolean[] isGanMao) {  
	        int ganmao = 0;// ��ð�����ϵ�����  
	        int likai = 0;// �뿪���ӵ����ϵ�����  
	  
	        while (likai < count) {  
	            for (int i = 0; i < count; i++) {// ��ÿֻ���ϵ����߼���  
	                if (Math.abs(julis[i]) == 0 || Math.abs(julis[i]) == 100) {  
	                    likai++;  
	                }  
	                else {  
	                    // ��ͷ�Ľ���  
	                    ganmao += exchange(julis, isGanMao);  
	                    julis[i]++;// �����ߵļ���������,�����ߵ�����  
	                }  
	            }  
	        }  
	        return ganmao;  
	    }  
	    public static boolean isPengTou(Integer A, Integer B) {  
	        // �ж��Ƿ���ͷ  
	        //if (A * B < 0 && A == B)// �������ͬ  
	        if (A * B < 0 && Math.abs(A)-Math.abs(B)==1)// �������ͬ  
	        {  
	            return true;  
	        }  
	        return false;  
	    }  
	    public static int exchange(Integer[] julis, boolean[] isGanMao) {  
	        int count = 0;  
	        // �����ͷ�ͽ�������,���ظ�ð��Ⱦ���Ӻ������  
	        for (int i = 0; i < julis.length; i++) {  
	            for (int j = i + 1; j < julis.length; j++) {  
	                if (isPengTou(julis[i], julis[j])) {  
	                    Integer temp = julis[i];  
	                    julis[i] = julis[j];  
	                    julis[j] = temp;  
	                    if ((isGanMao[j] == true && isGanMao[i] == false)  
	                            || (isGanMao[i] == true && isGanMao[j] == false)) {  
	                        isGanMao[i] = true;// ��ð��Ⱦ  
	                        isGanMao[j] = true;  
	                        count++;  
	                    }  
	  
	                }  
	            }  
	        }  
	        return count;  
	    }  
	    public static void print(Object o) {  
	        System.out.println(o.toString());  
	    }  
	} 

