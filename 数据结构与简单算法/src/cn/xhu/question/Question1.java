package cn.xhu.question;
/**
 * ����Թ�����
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
			if(i==xe && j==ye){//������ڳ����±���ջ��Ԫ��ȫ�����
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
				
				if(maze[i][j]==0){//����ÿ����
					q[top].setDi(di);
					top++;
					q[top] = new Qone();
					q[top].setX(i);
					q[top].setY(j);
					q[top].setDi(-1);
					find = true;//֤���ÿ����
					maze[i][j] = -1;//����ÿ鱻�ظ���
					break;					
				}
				di++;
			}
			
			if(!find){//���δ�ҵ����߿�,��ջ����ջ��top-1
				maze[q[top].getX()][q[top].getY()] = 0;//����λ��������Ϊ����
				top--;				
			}
			
		}
		System.out.println("δ�ҵ�");
		return;
	}
}
