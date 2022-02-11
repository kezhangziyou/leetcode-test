package problem9;

/**
 * @author zhangke
 * @version 1.0
 * @className Grid
 * @description
 * @date 2022/2/11 17:50
 **/
public class Grid {
	/**
	 * x坐标
	 */
	public int x;
	/**
	 * y坐标
	 */
	public int y;
	/**
	 * G和H的综合评估， 也就是从起点到达当前格子， 再从当前格子到达目标格子
	 * 的总步数。
	 */
	public int f;
	/**
	 * 从起点走到当前格子的成本， 也就是已经花费了多少步。
	 */
	public int g;
	/**
	 * 在不考虑障碍的情况下， 从当前格子走到目标格子的距离， 也就是离目标还
	 * 有多远。
	 */
	public int h;

	/**
	 * 父格子
	 */
	public Grid parent;

	public Grid(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void initGrid(Grid parent, Grid end){
		this.parent = parent;
		this.g = parent.g + 1;
		this.h = Math.abs(this.x - end.x) + Math.abs(this.y - end.y);
		this.f = this.g + this.h;
	}
}