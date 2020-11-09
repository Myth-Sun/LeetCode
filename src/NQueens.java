import java.util.ArrayList;
import java.util.List;

//N皇后问题
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> resList = new ArrayList<>();
        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                stringBuilder.append('.');
            }
            list.add(stringBuilder.toString());
            stringBuilder.delete(0, stringBuilder.length());
        }
        backtrack(resList, list, 0);
        return resList;
    }

    public void backtrack(List<List<String>> resList, List<String> board, int row) {
        //触发结束条件
        if (row == board.size()) {
            resList.add(new ArrayList<>(board));
            return;
        }
        int n = board.size();
        for (int col = 0; col < n; col++) {
            //排除不合法选择
            if (!isValid(board, row, col))
                continue;
            //做选择
            StringBuilder stringBuilder = new StringBuilder(board.get(row));
            stringBuilder.setCharAt(col, 'Q');
            board.set(row, stringBuilder.toString());

            //进入下一行决策
            backtrack(resList, board, row + 1);
            //撤销选择
            StringBuilder stringBuilder1 = new StringBuilder(board.get(row));
            stringBuilder1.setCharAt(col, '.');
            board.set(row, stringBuilder1.toString());
        }
    }

    public boolean isValid(List<String> board, int row, int col) {
        int n = board.size();
        //检查列
        for (int i = 0; i < n; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }
        //检查右上
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }
        //检查左上
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens nQueens = new NQueens();
        List<List<String>> lists = nQueens.solveNQueens(4);
//        System.out.println(resList.toString());
    }
}
