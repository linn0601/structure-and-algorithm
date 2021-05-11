package structure.recursion;

/**
 * 动态规划 / 递归
 */
public class Recursion {

	/**
	 *  爬楼梯，假设你正在爬楼梯，需要n阶你才能达到楼顶部，你每次可以爬1/2 台阶，你有多少种不同的方法可以爬到楼顶 n = 正整数
	 */
	public static int climbStairs(int n, int i) {

		// 结束条件
		if (i > n) {
			return 0;
		}
		if (n == i) {
			return 1;
		}

		// 递归调用
		return climbStairs(i + 1, i) + climbStairs(i + 2, i);
	}

	/**
	 * 斐波那契 fn = f (n -1) + f (n -2)
	 */
	private static int fib(int n) {
		// 结束条件
		if (n < 2) {
			return n;
		}
		else {
			return fib(n - 1) + fib(n - 2);
		}
	}
}
