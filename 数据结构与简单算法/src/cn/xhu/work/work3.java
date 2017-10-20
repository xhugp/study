package cn.xhu.work;

import java.util.Scanner;

public class work3 {
	    public static void main(String[] args) {  
	        int count;// 表示蚂蚁的总和  
	        String in;  
	        Integer[] julis;  
	        Scanner scanner = new Scanner(System.in);  
	        count = scanner.nextInt();  
	        scanner.nextLine();  
	        julis = new Integer[count];// 用来装载具体的每只蚂蚁的距离  
	        boolean[] isGanMao = new boolean[count];// 每只蚂蚁是否感冒的具体数据  
	        in = scanner.nextLine();  
	        long start = System.currentTimeMillis();  
	        String[] strings = in.split(" ");  
	        for (int i = 0; i < count; i++) {  
	            julis[i] = new Integer(strings[i]);  
	            isGanMao[i] = false;  
	        }// 数据输入完成  
	        isGanMao[0] = true;  
	        print(calculate(count, julis, isGanMao)+1);//感染的其他蚂蚁的数量和第一个干嘛的蚂蚁  
	        long end = System.currentTimeMillis();  
	        print("此程序运行,花费的时间是" + ((end - start) / 1000.0) + "秒.");  
	    }  
	  
	    public static int calculate(int count, Integer[] julis, boolean[] isGanMao) {  
	        int ganmao = 0;// 感冒的蚂蚁的数量  
	        int likai = 0;// 离开杆子的蚂蚁的数量  
	  
	        while (likai < count) {  
	            for (int i = 0; i < count; i++) {// 对每只蚂蚁的行走计算  
	                if (Math.abs(julis[i]) == 0 || Math.abs(julis[i]) == 100) {  
	                    likai++;  
	                }  
	                else {  
	                    // 碰头的交换  
	                    ganmao += exchange(julis, isGanMao);  
	                    julis[i]++;// 向左走的继续向左走,向右走得向右  
	                }  
	            }  
	        }  
	        return ganmao;  
	    }  
	    public static boolean isPengTou(Integer A, Integer B) {  
	        // 判断是否碰头  
	        //if (A * B < 0 && A == B)// 如果方向不同  
	        if (A * B < 0 && Math.abs(A)-Math.abs(B)==1)// 如果方向不同  
	        {  
	            return true;  
	        }  
	        return false;  
	    }  
	    public static int exchange(Integer[] julis, boolean[] isGanMao) {  
	        int count = 0;  
	        // 如果碰头就交换方向,返回感冒传染增加后的数量  
	        for (int i = 0; i < julis.length; i++) {  
	            for (int j = i + 1; j < julis.length; j++) {  
	                if (isPengTou(julis[i], julis[j])) {  
	                    Integer temp = julis[i];  
	                    julis[i] = julis[j];  
	                    julis[j] = temp;  
	                    if ((isGanMao[j] == true && isGanMao[i] == false)  
	                            || (isGanMao[i] == true && isGanMao[j] == false)) {  
	                        isGanMao[i] = true;// 感冒传染  
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

