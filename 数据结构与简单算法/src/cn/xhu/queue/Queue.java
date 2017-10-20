package cn.xhu.queue;

import java.util.Arrays;
/**
 * ѭ�����е�˳��洢ʵ��
 * @author Administrator
 *
 * @param <T>
 */
public class Queue<T> {
	private Object[] queue;
	private int start;
	private int end;
	private int que_len;
	private int que_num;
	
	public Queue(){
		this(5);
	}
	public Queue(int len){
		start = 0;
		end = 0;
		que_len = len;
		que_num = 0;
		queue = new Object[len];
	}
	/**
	 * �ж϶����Ƿ�Ϊ��
	 * @return
	 */
	public boolean queEmtity(){
		if(que_num == 0 ){
			return true;
		}
		return false;
	}
	/**
	 * �ж϶����Ƿ�����
	 * @return
	 */
	public boolean queFull(){
		if(que_len == que_num){
			return true;
		}
		return false;
	}
	/**
	 * �õ����г���
	 * @return
	 */
	public int getLen(){
		return que_len;
	}
	
	public void clear(){
		Arrays.fill(queue,null);
		que_num = 0;
		start = 0;
		end = 0;
	}
	public int getNum(){
		return que_num;
	}
	
	/**
	 * �����
	 * @param par
	 */
	public void EnQueue(T par){
        if(queFull()){
        	return;
        }
        else{
			queue[end] = par;
			que_num++;
			end = (end + 1) % que_len;		
			return;
		}
	}
	/**
	 * ����
	 * @param i
	 */
	@SuppressWarnings("unchecked")
	public T outQueue(){
		T i;
		if(queEmtity()){
			return null;
		}
		else{			
			i = (T) queue[start];
			queue[start] = (Integer) null;
			que_num--;
			start = (start+1)%que_len;
			return i;
		}
	}	
	
	/**
	 * ��������
	 */
	public void dispaly(){
		if(queEmtity()){
			return;
		}
		else{
			for(int i = start;i < que_len + start;i++){
				System.out.print(queue[i%que_len]+" ");
				System.out.println("ǰ�湲�У�"+(i-start)+"λ");				
			}
		}
	}
}
