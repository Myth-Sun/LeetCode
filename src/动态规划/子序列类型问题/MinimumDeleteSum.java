package 动态规划.子序列类型问题;

import java.util.Arrays;

/** 712. 两个字符串的最小ASCII删除和
 * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
 *
 * 示例 1:
 *
 * 输入: s1 = "sea", s2 = "eat"
 * 输出: 231
 * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
 * 在 "eat" 中删除 "t" 并将 116 加入总和。
 * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
 * 示例2:
 *
 * 输入: s1 = "delete", s2 = "leet"
 * 输出: 403
 * 解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
 * 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
 * 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
 * 如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
 * 注意:
 *
 * 0 < s1.length, s2.length <= 1000。
 * 所有字符串中的字符ASCII值在[97, 122]之间。
 */
public class MinimumDeleteSum {

    int memo[][];

    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        memo = new int[m][n];
        for (int[] row : memo)
            Arrays.fill(row, -1);
        return dp(s1, 0, s2, 0);
    }

//    public int minimumDeleteSum1(String s1, String s2) {
//        int m = s1.length(), n = s2.length(),res=0;
//        System.out.println("m"+m);
//        System.out.println("n"+n);
//        memo = new int[m+1][n+1];
//        for(int i=0;i<=m;i++)
//            memo[i][0]=0;
//        for(int j=0;j<=n;j++)
//            memo[0][j]=0;
//
//        for(int i=1;i<=m;i++){
//            for(int j=1;j<=n;j++){
//                if(i==m){
//                    for(int q=j;q<n;q++)
//                        memo[i][j]+=s2.charAt(q);
//                    return memo[i][j];
//                }
//                if(j==n){
//                    for(int q=i;q<m;q++)
//                        memo[i][j]+=s1.charAt(q);
//                    return memo[i][j];
//                }
//                if(s1.charAt(i-1)==s2.charAt(j-1))
//                    memo[i][j]=memo[i-1][j-1];
//                else{
//                    memo[i][j]=Math.min(s1.charAt(i-1)+memo[i][j-1],s2.charAt(j-1)+memo[i-1][j]);
//                }
//            }
//        }
//        return dp(s1, 0, s2, 0);
//    }

    public int dp(String s1, int i, String s2, int j) {
        int res = 0;
        //s1已遍历完
        if (i == s1.length()) {
            for (; j < s2.length(); j++)
                res += s2.charAt(j);
            return res;
        }
        //s2已遍历完
        if (j == s2.length()) {
            for (; i < s1.length(); i++)
                res += s1.charAt(i);
            return res;
        }
        if (memo[i][j] != -1)
            return memo[i][j];
        if (s1.charAt(i) == s2.charAt(j))
            memo[i][j] = dp(s1, i + 1, s2, j + 1);
        else {
            memo[i][j] = Math.min(s1.charAt(i) + dp(s1, i + 1, s2, j), s2.charAt(j) + dp(s1, i, s2, j + 1));
        }
        return memo[i][j];
    }


    public static void main(String[] args) {
        MinimumDeleteSum minimumDeleteSum = new MinimumDeleteSum();
        int res = minimumDeleteSum.minimumDeleteSum("delete", "leet");
        System.out.println(res);
    }
}
