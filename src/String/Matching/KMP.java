package String.Matching;

public class KMP {

    // time: O(n)
    // space: O(n)
    private static int[] helper(String pattern) {
        int n = pattern.length();
        int[] PMT = new int[n];

        int i = 0, j = 1;
        while(j < n) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                PMT[j] = i + 1;
                i++;
                j++;

            } else {
                if (i == 0) {
                    PMT[j] = 0;
                    j++;
                } else {
                    i = PMT[i - 1];
                }
            }
        }

        return PMT;
    }

    // KMP: use extra space to make matching faster
    // time: O(m + n)
    // space: O(n)
    private static boolean KMP(String text, String pattern) {
        int m = text.length(), n = pattern.length();
        int[] PMT = helper(pattern);

        int i = 0, j = 0;
        while(i < m && j < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j == 0) {
                    i++;
                } else {
                    j = PMT[j - 1];
                }
            }
        }

        // if j >= n -> matching, then i will point to the index of last matching character + 1
        // the start matching index of text will be i - n
        if (j >= n) {
            System.out.println(i - n);
            return true;
        } else {
            System.out.println(-1);
            return false;
        }
    }

    public static void main(String[] args) {
        String text = "abcxabcd ｜ abcdabcy";
        String pattern = "abcdabcy";

        System.out.println(KMP(text, pattern));
    }
}
