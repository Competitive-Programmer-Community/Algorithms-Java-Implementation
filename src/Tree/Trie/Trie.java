package Tree.Trie;


// https://leetcode.com/problems/design-add-and-search-words-data-structure/
public class Trie {
    TrieNode root;

    public void add(String word) {
        TrieNode cur = root;
        TrieNode[] children = cur.children;
        for (char ch: word.toCharArray()) {
            if (children[ch - 'a'] == null) {
                children[ch - 'a'] = new TrieNode(ch);
            }
            cur = children[ch - 'a'];
            children = cur.children;
        }
        cur.isWord = true;
        cur.word = word;
    }

    public TrieNode startWith(String prefix) {
        TrieNode cur = root;
        TrieNode[] children = cur.children;
        for (char ch: prefix.toCharArray()) {
            if (children[ch - 'a'] == null) {
                return null;
            }
            cur = children[ch - 'a'];
            children = cur.children;
        }
        return cur;
    }

    // 由startWith(prefix)得到prefix最后一个ch对应的TrieNode, 以之为起点进行DFS + backtracking找到所有以prefix开头的words
    public boolean contains(String word) {
        TrieNode node = startWith(word);
        if (node == null || node.isWord == false) {
            return false;
        }
        return true;
    }

    // 判断给定word是否有匹配字符串. 字母和'.': 其中.可以匹配任意字符
    public boolean search(String word) {
        return search(root, word, 0);
    }
    private boolean search(TrieNode cur, String word, int index) {
        if (index == word.length()) {
            return cur.isWord;
        }

        if (word.charAt(index) == '.') {
            for (TrieNode child: cur.children) {
                if (search(child, word, index + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            char ch = word.charAt(index);
            cur = cur.children[ch - 'a'];
            return cur != null ? search(cur, word, index + 1) : false;
        }
    }

    public static void main(String[] args) {

    }
}

