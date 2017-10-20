package cn.xhu.stack;


import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import cn.xhu.entity.Student;
import cn.xhu.thread.myThread;

public class stackTest {
	@Test
	public void test1(){
		try{
			MyStack<Integer> stack = new MyStack<Integer>(4);
			stack.push(8);
			stack.push(3);
			stack.push(9);
			stack.push(1);
			stack.clear();
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
			System.out.println(stack.pop());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	
	}
	@Test
	public void test2(){
		MyStack<Student> stack = new MyStack<Student>(3);
		Student s1 = new Student("张三",12);
		Student s2 = new Student("李四",12);
		Student s3 = new Student("王五",12);
		stack.push(s1);
		stack.push(s2);
		stack.push(s3);
		System.out.println(stack.getNum());
		stack.display(false);

		
	}
	@Test
	public void test3(){
		MyStack<Student> stack = new MyStack<Student>(3);
		Student s1 = new Student("张三",12);
		Student s2 = new Student("李四",12);
		Student s3 = new Student("王五",12);
		stack.push(s1);
		stack.push(s2);
		stack.push(s3);
		myThread m = new myThread(stack);
		
		Thread t1 = new Thread(m,"t1");
		Thread t2 = new Thread(m,"t2");
		Thread t3 = new Thread(m,"t3");
		Thread t4 = new Thread(m,"t4");
		Thread t5 = new Thread(m,"t5");
		Thread t6 = new Thread(m,"t6");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		
		 
		
	}
}
