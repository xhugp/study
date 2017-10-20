package cn.xhu.stack;

import org.junit.Test;

import cn.xhu.entity.Student;

public class stackTest2 {
	private static int x = 100;
	@Test
	public  void test1(){
		Mystack2<Integer> stack = new Mystack2<Integer>();
		stack.push(4);
		stack.push(3);
		stack.push(8);
		stack.push(7);
		//得到栈顶元素
		System.out.println(stack.getTop());
		//出栈		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stackTest2 t = new stackTest2();
		
	}
	@Test
	public void test2(){
		Mystack2<Student> stack = new Mystack2<Student>();
		Student s1 = new Student("张三",12);
		Student s2 = new Student("李四",12);
		Student s3 = new Student("王五",12);
		stack.push(s1);
		stack.push(s2);
		stack.push(s3);
		//得到栈顶元素
		System.out.println(stack.getTop());
		//遍历栈
		stack.printList();
	}
	
	
}
