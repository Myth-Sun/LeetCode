package 树;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 648. 单词替换
 * 在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * <p>
 * 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * <p>
 * 你需要输出替换之后的句子。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * 示例 2：
 * <p>
 * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * 输出："a a b c"
 * 示例 3：
 * <p>
 * 输入：dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
 * 输出："a a a a a a a a bbb baba a"
 * 示例 4：
 * <p>
 * 输入：dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * 示例 5：
 * <p>
 * 输入：dictionary = ["ac","ab"], sentence = "it is abnormal that this solution is accepted"
 * 输出："it is ab that this solution is ac"
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写字母组成。
 * 1 <= sentence.length <= 10^6
 * sentence 仅由小写字母和空格组成。
 * sentence 中单词的总量在范围 [1, 1000] 内。
 * sentence 中每个单词的长度在范围 [1, 1000] 内。
 * sentence 中单词之间由一个空格隔开。
 * sentence 没有前导或尾随空格。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/replace-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//利用前缀树实现
public class ReplaceWords {

    class TrieNode {
        HashMap<Character, TrieNode> map = new HashMap<>();
        boolean isEnd = false;
        char c;
        String word;

        public TrieNode(char c) {
            this.c = c;
        }

        public TrieNode() {

        }
    }


    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode curNode = root;
            for (char c : word.toCharArray()) {
                if (curNode.map.containsKey(c)) {
                    curNode = curNode.map.get(c);
                } else {
                    TrieNode node = new TrieNode(c);
                    curNode.map.put(c, node);
                    curNode = node;
                }
            }
            curNode.isEnd = true;
            curNode.word = word;
        }

        String[] sentenceWords = sentence.split("\\s+");
        StringBuilder stringBuilder = new StringBuilder();

        for (String sentenceWord : sentenceWords) {
            System.out.println("sentenceWord:" + sentenceWord);
            TrieNode curNode = root;
            for (char c : sentenceWord.toCharArray()) {
                if (curNode.map.containsKey(c)) {
                    curNode = curNode.map.get(c);
                } else {
                    break;
                }
                if (curNode.isEnd == true) {
                    System.out.println("curNode.word:" + curNode.word);
                    stringBuilder.append(curNode.word + " ");
                    break;
                }
            }
            if (curNode.isEnd != true) {
                stringBuilder.append(sentenceWord + " ");
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ReplaceWords replaceWords = new ReplaceWords();
        ArrayList<String> list = new ArrayList<>();
        list.add("a");
        list.add("aa");
        list.add("aaa");
        list.add("aaaa");
        String[] list1 = {"e", "k", "c", "harqp", "h", "gsafc", "vn", "lqp", "soy", "mr", "x", "iitgm", "sb", "oo", "spj", "gwmly", "iu", "z", "f", "ha", "vds", "v", "vpx", "fir", "t", "xo", "apifm", "tlznm", "kkv", "nxyud", "j", "qp", "omn", "zoxp", "mutu", "i", "nxth", "dwuer", "sadl", "pv", "w", "mding", "mubem", "xsmwc", "vl", "farov", "twfmq", "ljhmr", "q", "bbzs", "kd", "kwc", "a", "buq", "sm", "yi", "nypa", "xwz", "si", "amqx", "iy", "eb", "qvgt", "twy", "rf", "dc", "utt", "mxjfu", "hm", "trz", "lzh", "lref", "qbx", "fmemr", "gil", "go", "qggh", "uud", "trnhf", "gels", "dfdq", "qzkx", "qxw"};
        String sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa";
        String s = replaceWords.replaceWords(list, sentence);
        System.out.println(s);
    }

}
