import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class Permutation {
    List<List<Integer>> resultList = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> track = new LinkedList<>();
        backtrack(nums, track);
        return resultList;
    }

    public void backtrack(int[] nums, List<Integer> track) {
        if (track.size() == nums.length) {
            resultList.add(new LinkedList<>(track));
            return;
        }
        for (int num : nums) {
            if (track.contains(num))
                continue;
            track.add(num);
            backtrack(nums, track);;
            track.remove(track.size() - 1);
        }
    }
}
