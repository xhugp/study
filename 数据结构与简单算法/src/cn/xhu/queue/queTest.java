package cn.xhu.queue;

import org.junit.Test;

import cn.xhu.entity.Student;

public class queTest {
	@Test
	public void test1() {
		// TODO Auto-generated method stub
		Queue<Integer> que = new Queue<Integer>(4);
		que.EnQueue(5);
		que.EnQueue(2);
		que.EnQueue(8);
		que.EnQueue(30);
		que.EnQueue(80);
		//�������
		que.dispaly();
		System.out.println();
		//������
		int m;
		m = que.outQueue();
		System.out.println(m+"������");				
		m = que.outQueue();
		System.out.println(m+"������");
		System.out.println();
				
		que.EnQueue(25);
		que.dispaly();
		//�����
		que.clear();			
		System.out.println(que.getNum());
		que.dispaly();
	}
	
	@Test
	public void test2(){
		Queue<Student> que = new Queue<Student>(3);
		Student s1 = new Student("����",12);
		Student s2 = new Student("����",12);
		Student s3 = new Student("����",12);
		que.EnQueue(s1);
		que.EnQueue(s2);
		que.EnQueue(s3);
		
		Student s = que.outQueue();
		System.out.println(s);
		que.dispaly();
	}

}
