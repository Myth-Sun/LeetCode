package 动态规划.其他经典问题;

/**
 * 动态规划之博弈问题
 * 你和你的朋友面前有一排石头堆，用一个数组 piles 表示，piles[i] 表示第 i 堆石子有多少个。你们轮流拿石头，一次拿一堆，但是只能拿走最左边或者最右边的石头堆。所有石头被拿完后，谁拥有的石头多，谁获胜。
 * 石头的堆数可以是任意正整数，石头的总数也可以是任意正整数，这样就能打破先手必胜的局面了。比如有三堆石头 piles = [1, 100, 3]，先手不管拿 1 还是 3，能够决定胜负的 100 都会被后手拿走，后手会获胜。
 * 假设两人都很聪明，请你设计一个算法，返回先手和后手的最后得分（石头总数）之差。比如上面那个例子，先手能获得 4 分，后手会获得 100 分，你的算法应该返回 -96。
 */
public class StoneGame {

  class Pair {

    int fir, sec;

    Pair(int fir, int sec) {
      this.fir = fir;
      this.sec = sec;
    }
  }

  public int stoneGame(int[] piles) {
    int n = piles.length;
    //初始化dp数组
    //dp[i][j].fir 表示，对于 piles[i...j] 这部分石头堆，先手能获得的最高分数。
    //dp[i][j].sec 表示，对于 piles[i...j] 这部分石头堆，后手能获得的最高分数。
    Pair[][] dp = new Pair[n][n];
    //只需初始化上半部分dp数组
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n; j++) {
        dp[i][j] = new Pair(0, 0);
      }
    }
    //base case:i=j,此时先手的得分为piles[i]，后手没有石头拿，得分为0
    for (int i = 0; i < n; i++) {
      dp[i][i].fir = piles[i];
      dp[i][i].sec = 0;
    }
    //斜着遍历数组
    for(int l=2;l<=n;l++){
      for(int i=0;i<=n-l;i++){
        int j=l+i-1;
        //先手选择最左边的石头，然后面对piles[i+1...j],此时相当于变成了后手
        int left=piles[i]+dp[i+1][j].sec;
        //先手选择最右边的石头，然后面对piles[i...j-1],此时相当于变成了后手
        int right=piles[j]+dp[i][j-1].sec;
        //状态转移方程
        if(left>right){
          dp[i][j].fir=left;
          dp[i][j].sec=dp[i+1][j].fir;
        }else {
          dp[i][j].fir=right;
          dp[i][j].sec=dp[i][j-1].fir;
        }
      }
    }
    Pair res=dp[0][n-1];
    return res.fir - res.sec;
  }

  public static void main(String[] args) {
    StoneGame stoneGame = new StoneGame();
    int[] piles = {3,9,1,2};
    int res = stoneGame.stoneGame(piles);
    System.out.println(res);
  }
}
