package cn.xhu.stack;
/**
 * 顺序栈
 * @author Administrator
 *
 * @param <T>
 */
public class MyStack<T> {
	private int top;//栈顶
	private Object[] data;//定义栈
	private int len;//栈的大小
	private int num;//当前栈中数据数量
	
	public MyStack(){
		
	}
	/**
	 * 初始化栈
	 * @param length
	 */
	public MyStack(int length){
		data = new Object[length];
		len = length;
		num = 0;
		top = -1;
	}
	
	/**
	 * 清空栈
	 */
	public void clear(){
		top = -1;
		num = 0;
	}
	
	/**
	 * 栈判空
	 */
	public boolean isEmtity(){
		if(top==-1){
			return true;
		}
		return false;
	}
	/**
	 * 栈判满
	 * @return
	 */
	public boolean isFull(){
		if(num == len){
			return true;
		}
		return false;
	}
	/**
	 * 出栈
	 */
	@SuppressWarnings("unchecked")
	public T pop(){
		if(isEmtity()){
			throw new RuntimeException("栈空");
		}
		else{
			return (T) data[top--];
		}
		
	}
	/**
	 * 入栈
	 */
	public synchronized void push(T par){
		if(isFull()){
			throw new RuntimeException("栈满");
		}
		else{
			data[++top] = par;
			num++;
		}
	}
	/**
	 * 得到栈中元素数量
	 */
	public int getNum(){
		return num;
	}
	/**
	 * 遍历栈
	 * @param isDec 确定遍历方向
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
