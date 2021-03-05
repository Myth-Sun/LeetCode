package 其他;

import java.util.Scanner;

/*
给出一个正整数N和长度L，找出一段长度大于等于L的连续非负整数，他们的和恰好为N。答案可能有多个，我我们需要找出长度最小的那个。
例如 N = 18 L = 2：
5 + 6 + 7 = 18
3 + 4 + 5 + 6 = 18
都是满足要求的，但是我们输出更短的 5 6 7
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(), L = scan.nextInt();
        scan.close();
        boolean flag = false;
        for (int i = L; i <= 100; i++) {
            if ((2 * N - i * (i - 1)) % (2 * i) == 0 && (2 * N - i * (i - 1)) / (2 * i) >= 0) {
                int a1 = (2 * N - i * (i - 1)) / (2 * i);
                for (int j = 0; j < i - 1; j++) {
                    System.out.printf(a1 + j + " ");
                }
                System.out.print(a1 + (i - 1));
                flag = true;
                break;
            }
        }
        if (flag == false)
            System.out.println("No");
    }
}
