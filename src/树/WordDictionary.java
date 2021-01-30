package 树;

import java.util.HashMap;

/**
 * 211. 添加与搜索单词 - 数据结构设计
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * <p>
 * 实现词典类 WordDictionary ：
 * <p>
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 * <p>
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 500
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最调用多 50000 次 addWord 和 search
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/design-add-and-search-words-data-structure
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//利用前缀树
public class WordDictionary {
    class TrieNode {
        //当前节点的字符
        char c;
        HashMap<Character, TrieNode> children = new HashMap<>();
        //标志是否为单词结尾
        boolean isEnd = false;

        public TrieNode(char c) {
            this.c = c;
        }

        public TrieNode() {

        }
    }

    /**
     * Initialize your data structure here.
     */
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        int n = word.length();
        TrieNode node = root;
        for (int i = 0; i < n; i++) {
            char c = word.charAt(i);
            if (node.children.containsKey(c)) {
                node = node.children.get(c);
            } else {
                TrieNode newNode = new TrieNode(c);
                node.children.put(c, newNode);
                node = newNode;
            }
        }
        node.isEnd = true;
    }

    public boolean search(String word) {

        return searchHelp(word, root);
    }

    public boolean searchHelp(String word, TrieNode node) {
        int n = word.length();
        TrieNode curNode = node;
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) == '.') {
                for (char c : curNode.children.keySet()) {
                    if (searchHelp(word.substring(i + 1), curNode.children.get(c))) {
                        return true;
                    }
                }
                return false;
            } else if (curNode.children.containsKey(word.charAt(i))) {
                curNode = curNode.children.get(word.charAt(i));
            } else {
                return false;
            }
        }
        return curNode.isEnd;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
