package cn.xhu.question;

public class Qone {
	private int x,y;//当前方块的坐标
	private int di;//下一个可走的方位
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getDi() {
		return di;
	}
	public void setDi(int di) {
		this.di = di;
	}
	@Override
	public String toString() {
		return "Qone [x=" + x + ", y=" + y + ", di=" + di + "]";
	}
	
	
}
