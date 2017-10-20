package cn.xhu.stack;
/**
 * ˳��ջ
 * @author Administrator
 *
 * @param <T>
 */
public class MyStack<T> {
	private int top;//ջ��
	private Object[] data;//����ջ
	private int len;//ջ�Ĵ�С
	private int num;//��ǰջ����������
	
	public MyStack(){
		
	}
	/**
	 * ��ʼ��ջ
	 * @param length
	 */
	public MyStack(int length){
		data = new Object[length];
		len = length;
		num = 0;
		top = -1;
	}
	
	/**
	 * ���ջ
	 */
	public void clear(){
		top = -1;
		num = 0;
	}
	
	/**
	 * ջ�п�
	 */
	public boolean isEmtity(){
		if(top==-1){
			return true;
		}
		return false;
	}
	/**
	 * ջ����
	 * @return
	 */
	public boolean isFull(){
		if(num == len){
			return true;
		}
		return false;
	}
	/**
	 * ��ջ
	 */
	@SuppressWarnings("unchecked")
	public T pop(){
		if(isEmtity()){
			throw new RuntimeException("ջ��");
		}
		else{
			return (T) data[top--];
		}
		
	}
	/**
	 * ��ջ
	 */
	public synchronized void push(T par){
		if(isFull()){
			throw new RuntimeException("ջ��");
		}
		else{
			data[++top] = par;
			num++;
		}
	}
	/**
	 * �õ�ջ��Ԫ������
	 */
	public int getNum(){
		return num;
	}
	/**
	 * ����ջ
	 * @param isDec ȷ����������
	 */
	public void display(boolean isDec){
		if(isDec){
			for(int i=top;i>=0;i--){
				System.out.println(data[i]);
			}
		}else{
			for(int i=0;i<=top;i++){
				System.out.println(data[i]);
			}
		}
	}
}
