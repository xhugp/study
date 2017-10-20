package cn.xhu.thread;

import cn.xhu.entity.Student;
import cn.xhu.stack.MyStack;

public class myThread implements Runnable {
	private MyStack<Student> stack;
	
	public myThread(MyStack<Student> stack2){
		this.stack = stack2;
	}
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"线程开始");
		try{
			System.out.println(Thread.currentThread().getName()+" "+stack.pop());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println(Thread.currentThread().getName()+"线程结束");
	}

}
