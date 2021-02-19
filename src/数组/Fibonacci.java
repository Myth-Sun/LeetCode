package 数组;

/*
斐波那契数列
题目描述
大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
n\leq 39n≤39

示例1
输入

4
返回值

3
 */
public class Fibonacci {
    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int dp0 = 0, dp1 = 1;
        for (int i = 2; i <= n; i++) {
            int sum = (dp0 + dp1) % 1000000007;
            dp0 = dp1;
            dp1 = sum;
        }
        return dp1;
    }

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.fibonacci(4));
    }
}
