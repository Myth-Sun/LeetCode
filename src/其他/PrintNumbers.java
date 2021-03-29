package 其他;

/*
剑指 Offer 17. 打印从1到最大的n位数
输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

示例 1:

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]


说明：

用返回一个整数列表来代替打印
n 为正整数
 */
public class PrintNumbers {
    public int[] printNumbers(int n) {
        int num = (int) Math.pow(10, n) - 1;
        int[] ans = new int[num];
        for (int i = 0; i < num; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }

    StringBuilder stringBuilder;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    int n;

    public String printNumbersII(int n) {
        stringBuilder = new StringBuilder();
        num = new char[n];
        this.n = n;
        dfs(0);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public void dfs(int x) {
        if (x == n) {
            stringBuilder.append(String.valueOf(num) + ",");
            return;
        }
        for (int i = 0; i < loop.length; i++) {
            num[x] = loop[i];
            dfs(x + 1);
        }
    }

    public static void main(String[] args) {
        PrintNumbers printNumbers = new PrintNumbers();
        System.out.println(printNumbers.printNumbersII(1));
    }
}
