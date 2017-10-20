package cn.xhu.stack;

public class Mystack2<T> {
	private Node<T> top;
		
	public Mystack2() {
		top = null;
	}	
	/**
	 * ÈëÕ»
	 */
	public void push(T i){
		Node<T> s = new Node<T>();
		s.setData(i);
		s.setNext(top);
		top = s;	
	}
	
	/**
	 * ³öÕ»
	 */
	public T pop(){
		if(Empty()){
			throw new RuntimeException("Õ»Îª¿Õ");
		}
		else{
			T m = top.getData();
			Node<T> q = top.getNext();
			top = q;
			return m;
		}
	}
	
	/**
	 * ÅÐ¿Õ
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
	 * È¡Õ»¶¥ÔªËØ
	 */
	
	public T getTop(){
		if(Empty()){
			throw new RuntimeException("Õ»Îª¿Õ");
		}
		else{
			return top.getData();
		}
	}
	
	/**
	 * ±éÀúÕ»
	 */
	public void printList(){
		if(Empty()){
			throw new RuntimeException("Õ»Îª¿Õ");
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
