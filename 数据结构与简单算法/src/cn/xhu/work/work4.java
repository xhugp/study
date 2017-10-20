package cn.xhu.work;

import java.util.Scanner;
import java.util.Stack;

import cn.xhu.stack.MyStack;

public class work4 {
	private static TreeNode root = null;
	private static MyStack<Object> stack = new MyStack<Object>(20);
	class TreeNode{
		char c;
		TreeNode left;
		TreeNode right;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("输入一个表达式：");
		String str = sc.nextLine();
		Parse(str);
		//GetValue(root);
		sc.close();
	}
//	private static void GetValue(TreeNode root2) {
//		// TODO Auto-generated method stub
//		
//	}
	private static void Parse(String str) {
		char[] ch = str.toCharArray();
		for (char c : ch) {
			if(c>='0'&&c<='9'){
				stack.push(c);
			}else{
				int a = (char) stack.pop()-'0';
				int b = (char) stack.pop()-'0';
				switch (c) {
				case '+':
					stack.push(b+a);
					break;
				case '-':
					stack.push(b-a);
					break;
				case '*':
					stack.push(b*a);
					break;
				default:
					System.out.println("表达式不正确");
					break;
				}
			}
		}
//		System.out.println(stack.getNum());
//		if(stack.getNum()!=1){
//			System.out.println("表达式非法");			
//		}else{
			System.out.println((int)stack.pop());
//		}
		
	}

}
