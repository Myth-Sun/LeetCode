package 数组;

public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {

        return new int[]{};
    }

    public static void main(String[] args) {
        int[] test = {1, 1, 1,2};
        int res = 1;
        for (int num : test) {
            res ^= num;
        }
        System.out.println(res);
    }
}
