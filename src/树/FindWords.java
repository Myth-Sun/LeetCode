package 树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 212. 单词搜索 II
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 * <p>
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
 * <p>
 * 示例 1：
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]], words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 * <p>
 * 示例 2：
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindWords {
    List<String> ans = new ArrayList<>();
    char[][] _board;

    class TrieNode {
        char c;
        HashMap<Character, TrieNode> children = new HashMap<>();
        String word = null;

        public TrieNode(char c) {
            this.c = c;
        }

        public TrieNode() {

        }

    }

    public TrieNode addWords(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode curNode = root;
            for (char c : word.toCharArray()) {
                if (curNode.children.containsKey(c)) {
                    curNode = curNode.children.get(c);
                } else {
                    TrieNode newNode = new TrieNode(c);
                    curNode.children.put(c, newNode);
                    curNode = newNode;
                }
            }
            curNode.word = word;
        }
        return root;
    }

    public void backtracking(int row, int col, TrieNode parent) {
        char c = _board[row][col];
        TrieNode curNode = parent.children.get(c);
        if (curNode.word != null) {
            ans.add(curNode.word);
            curNode.word = null;
        }

        //防止该单元格的字母被重复使用
        _board[row][col] = '#';

        //上下左右遍历
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];

            if (newRow < 0 || newRow >= _board.length || newCol < 0 || newCol >= _board[0].length) {
                continue;
            }
            if (curNode.children.containsKey(_board[newRow][newCol])) {
                backtracking(newRow, newCol, curNode);
            }
        }
        _board[row][col] = c;
        if (curNode.children.isEmpty()) {
            parent.children.remove(c);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {

        _board = board;
        TrieNode root = addWords(words);

        //遍历board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (root.children.containsKey(board[i][j])) {
                    backtracking(i, j, root);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        FindWords findWords = new FindWords();
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};

        List<String> words1 = findWords.findWords(board, words);
        System.out.println(words1);
    }
}
