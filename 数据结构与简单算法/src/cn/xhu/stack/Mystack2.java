package cn.xhu.stack;

public class Mystack2<T> {
	private Node<T> top;
		
	public Mystack2() {
		top = null;
	}	
	/**
	 * ��ջ
	 */
	public void push(T i){
		Node<T> s = new Node<T>();
		s.setData(i);
		s.setNext(top);
		top = s;	
	}
	
	/**
	 * ��ջ
	 */
	public T pop(){
		if(Empty()){
			throw new RuntimeException("ջΪ��");
		}
		else{
			T m = top.getData();
			Node<T> q = top.getNext();
			top = q;
			return m;
		}
	}
	
	/**
	 * �п�
	 */
	public boolean Empty(){
		if(top==null){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	 * ȡջ��Ԫ��
	 */
	
	public T getTop(){
		if(Empty()){
			throw new RuntimeException("ջΪ��");
		}
		else{
			return top.getData();
		}
	}
	
	/**
	 * ����ջ
	 */
	public void printList(){
		if(Empty()){
			throw new RuntimeException("ջΪ��");
		}
		else{
			Node<T> q = top;
			while(q!=null){
				System.out.println(q.getData());
				q = q.getNext();
			}
		}
	}
	
	/**
	 * 
	 */
}
