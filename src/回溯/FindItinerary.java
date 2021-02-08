package 回溯;

import java.util.*;

/**
 * 332. 重新安排行程
 * 给定一个机票的字符串二维数组 [from, to]，子数组中的两个成员分别表示飞机出发和降落的机场地点，对该行程进行重新规划排序。所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，所以该行程必须从 JFK 开始。
 *
 * 提示：
 *
 * 如果存在多种有效的行程，请你按字符自然排序返回最小的行程组合。例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
 * 所有的机场都用三个大写字母表示（机场代码）。
 * 假定所有机票至少存在一种合理的行程。
 * 所有的机票必须都用一次 且 只能用一次。
 * 
 *
 * 示例 1：
 *
 * 输入：[["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * 输出：["JFK", "MUC", "LHR", "SFO", "SJC"]
 * 示例 2：
 *
 * 输入：[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * 输出：["JFK","ATL","JFK","SFO","ATL","SFO"]
 * 解释：另一种有效的行程是["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reconstruct-itinerary
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindItinerary {
    List<String> ans = new ArrayList<>();
    //利用PriorityQueue排序
    Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    int ticketNum;

    public List<String> findItinerary(List<List<String>> tickets) {
        this.ticketNum = tickets.size() + 1;
        for (List<String> ticket : tickets) {
            String source = ticket.get(0), destination = ticket.get(1);
            if (!map.containsKey(source)) {
                map.put(source, new PriorityQueue<>());
            }
            map.get(source).offer(destination);
        }

        backtracking("JFK");
        Collections.reverse(ans);
        return ans;
    }

    public void backtracking(String source) {
        while (map.containsKey(source) && map.get(source).size() > 0) {
            String temp = map.get(source).poll();
            backtracking(temp);
        }
        ans.add(source);
    }

}
