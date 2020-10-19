package Tree.Trie;

import java.util.HashMap;

// 改变TrieNode, 增加变量
public class TrieNode {
    char ch;
    TrieNode[] children = new TrieNode[26]; // 数组表示next 26个小写字母
    boolean isWord = false; // 判断是否是某个词的词尾
    String word; // 以当前ch结尾的word

    public TrieNode() {} // 虚根节点
    public TrieNode(char ch) { // 一般节点 ch -> TrieNode
        this.ch = ch;
    }

}


//public class TrieNode {
//    char ch;
//    HashMap<Character, TrieNode> children = new HashMap<>(); // hashmap表示任意ch及其对应的TrieNode
//    boolean isWord = false; // 判断是否是某个词的词尾
//    String word; // 以当前ch结尾的word
//
//    public TrieNode() {} // 虚根节点
//    public TrieNode(char ch) { // 一般节点 ch -> TrieNode
//        this.ch = ch;
//    }
//}

