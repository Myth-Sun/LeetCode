package 数组;

/*
二维数组中的查找
题目描述
在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
示例1
输入
7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
返回值
true
 */
public class Find {
    //对每一行进行二分查找
    public boolean find(int target, int[][] array) {
        int rowNum = 0;
        int m = array.length;
        int n = array[0].length;
        while (rowNum < m) {
            int left = 0, right = n - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int midNum = array[rowNum][mid];
                if (target < midNum) {
                    right = mid - 1;
                } else if (target > midNum) {
                    left = mid + 1;
                } else {
                    return true;
                }
            }
            rowNum++;
        }
        return false;
    }

    public static void main(String[] args) {
        Find find = new Find();
        int target = 7;
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(find.find(target, array));
    }
}
