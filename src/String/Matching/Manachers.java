package String.Matching;


// 曼彻斯特算法求解 Longest Palindromic Substring
// time: O(n)
// space: O(n)
// https://leetcode.com/problems/longest-palindromic-substring/
// https://leetcode.wang/leetCode-5-Longest-Palindromic-Substring.html
public class Manachers {
    // 预处理: "babad" -> "^#b#a#b#a#d#$"
    private static String preprocess(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        if (n == 0) {
            sb.append("^$");
            return sb.toString();
        }

        sb.append("^");
        for (int i = 0; i < n; i++) {
            sb.append("#" + s.charAt(i));
        }

        sb.append("#$");
        return sb.toString();
    }


    private static String longestPalindrome(String s) {
        String t = preprocess(s);
        int n = t.length();
        int[] p = new int[n];

        // 记录当前需要考察的回文串的中心和右边界
        int C = 0, R = 0;

        // 遍历区间[1, n - 2], 前加^后加$，防止越界
        for (int i = 1; i < n - 1; i++) {
            // 假设已知p[i_mirror], 求解p[i]
            int i_mirror = 2 * C - i;
            if (R > i) {
                // 如果在范围内，则最大值值为R- i
                p[i] = Math.min(p[i_mirror], R - i);
            } else {
                // 如果不在范围内则初始化为0
                p[i] = 0;
            }

            // 以i为中心, p[i]为半径继续前后扩展 - 可能在R的右边还有元素，可以继续扩展p[i]
            while(t.charAt(i + p[i] + 1) == t.charAt(i - p[i] - 1)) {
                p[i]++;
            }

            // 如果超出半径，则更新中心和右边界
            if (i + p[i] > R) {
                C = i;
                R = i + p[i];
            }
        }


        // 寻找max(p[i])和对应的中心index
        int maxLen = 0;
        int index = 0;
        for (int i = 1; i < n - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                index = i;
            }
        }

        // 扩展后的半径 -> 扩展前的总长度
        int start = (index - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println(longestPalindrome("cbbd"));
    }

}
