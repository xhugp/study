package cn.xhu.question;
/**
 * 解决迷宫问题
 * @author Administrator
 *
 */
public class Question1 {
	private static Qone[] q = new Qone[500];
	private static int[][] maze = {
				{1,1,1,1,1,1,1,1,1,1},  
			    {1,0,0,1,0,0,0,1,0,1},  
			    {1,0,0,1,0,0,0,1,0,1},  
			    {1,0,0,0,0,1,1,0,0,1},  
			    {1,0,1,1,1,0,0,0,0,1},  
			    {1,0,0,0,1,0,0,0,0,1},  
			    {1,0,1,0,0,0,1,0,0,1},  
			    {1,0,1,1,1,0,1,1,0,1},  
			    {1,1,0,0,0,0,0,0,0,1},  
			    {1,1,1,1,1,1,1,1,1,1}				
	};
	private static int top = -1;
	
	public static void main(String[] args) {				
		findPath(1, 1, 8, 8);
		return;
		

	}
	
	static void findPath(int xi,int yi,int xe,int ye){
		int i,j,di;		
		top++;
		
		q[top] = new Qone();
		q[top].setX(xi);
		q[top].setY(yi);
		q[top].setDi(-1);
		maze[xi][yi] = -1;
		
		while(top>-1){
			boolean find = false;
			i = q[top].getX();
			j = q[top].getY();
	//		System.out.println(q[top]);
			if(i==xe && j==ye){//如果等于出口下标则将栈中元素全部输出
				for(int m = 0;m < top;m++){
					System.out.print("("+q[m].getX()+","+q[m].getY()+") ");
					if((m+1)%5==0){
						System.out.println();
					}
				}
				return;
			}	
			
			di = q[top].getDi();
			di++;
//			System.out.println(di);
			while(di<4){
				switch (di) {
				case 0:
					i = q[top].getX()-1;
					j = q[top].getY();
					break;
				case 1:
					i = q[top].getX();
					j = q[top].getY()+1;
					break;
				case 2:
					i = q[top].getX()+1;
					j = q[top].getY();
					break;
				case 3:
					i = q[top].getX();
					j = q[top].getY()-1;
					break;				
				}
				
				if(maze[i][j]==0){//如果该块可走
					q[top].setDi(di);
					top++;
					q[top] = new Qone();
					q[top].setX(i);
					q[top].setY(j);
					q[top].setDi(-1);
					find = true;//证明该块可走
					maze[i][j] = -1;//避免该块被重复走
					break;					
				}
				di++;
			}
			
			if(!find){//如果未找到可走块,将栈顶出栈，top-1
				maze[q[top].getX()][q[top].getY()] = 0;//将该位置重新设为可走
				top--;				
			}
			
		}
		System.out.println("未找到");
		return;
	}
}
