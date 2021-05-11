package structure.recursion;

/**
 * 动态规划 / 递归
 */
public class Recursion {

	public static void main(String[] args) {
		System.out.println(climbStairs2(2));
	}

	/**
	 * 爬楼梯，假设你正在爬楼梯，需要n阶你才能达到楼顶部，你每次可以爬1/2 台阶，你有多少种不同的方法可以爬到楼顶 n = 正整数
	 *
	 * 递归 ：斐波那契 动态规划法 ：
	 */
	public static int climbStairs(int n) {
		if (n == 0 | n == 1) {
			return 1;
		}

		return climbStairs(n - 1) + climbStairs(n - 2);
	}

	/**
	 * 动态规划法 dp[n] = dp[n-1] + dp[n-2]
	 */
	public static int climbStairs2(int n) {

		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}

		return dp[n];
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
