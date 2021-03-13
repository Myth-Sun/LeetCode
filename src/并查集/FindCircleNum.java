package 并查集;

import java.util.LinkedList;
import java.util.Queue;

/*
547. 省份数量
有 n 个城市，其中一些彼此相连，另一些没有相连。如果城市 a 与城市 b 直接相连，且城市 b 与城市 c 直接相连，那么城市 a 与城市 c 间接相连。

省份 是一组直接或间接相连的城市，组内不含其他没有相连的城市。

给你一个 n x n 的矩阵 isConnected ，其中 isConnected[i][j] = 1 表示第 i 个城市和第 j 个城市直接相连，而 isConnected[i][j] = 0 表示二者不直接相连。

返回矩阵中 省份 的数量。



示例 1：


输入：isConnected = [[1,1,0],[1,1,0],[0,0,1]]
输出：2
示例 2：


输入：isConnected = [[1,0,0],[0,1,0],[0,0,1]]
输出：3


提示：

1 <= n <= 200
n == isConnected.length
n == isConnected[i].length
isConnected[i][j] 为 1 或 0
isConnected[i][i] == 1
isConnected[i][j] == isConnected[j][i]
 */
public class FindCircleNum {
    //深度优先搜索
    public int findCircleNum1(int[][] isConnected) {
        int ans = 0, length = isConnected.length;
        boolean[] isVisited = new boolean[length];
        for (int i = 0; i < length; i++) {
            if (!isVisited[i]) {
                dfs(isConnected, isVisited, i);
                ans++;
            }
        }
        return ans;
    }

    public void dfs(int[][] isConnected, boolean[] isVisited, int i) {
        for (int j = 0; j < isConnected.length; j++) {
            if (!isVisited[j] && isConnected[i][j] == 1) {
                isVisited[j] = true;
                dfs(isConnected, isVisited, j);
            }
        }
    }

    //广度优先搜索
    public int findCircleNum2(int[][] isConnected) {
        int ans = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!isVisited[i]) {
                queue.add(i);
                while (!queue.isEmpty()) {
                    int root = queue.poll();
                    isVisited[root] = true;
                    for (int j = 0; j < isConnected.length; j++) {
                        if (!isVisited[j] && isConnected[root][j] == 1) {
                            queue.add(j);
                        }
                    }
                }
                ans++;
            }
        }
        return ans;
    }

    //并查集
    public int findCircleNum3(int[][] isConnected) {
        int ans = 0, provinces = isConnected.length;
        int[] parent = new int[provinces];
        for (int i = 0; i < provinces; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < provinces; i++) {
            for (int j = i + 1; j < provinces; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        for (int i = 0; i < provinces; i++) {
            if (parent[i] == i) {
                ans++;
            }
        }
        return ans;
    }

    //合并节点
    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    //查找节点的根节点
    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}
