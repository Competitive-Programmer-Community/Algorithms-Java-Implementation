package String.Matching;


/**
 * Rabin-Karp is used for plagiarism detection and "look for similarities in two or more strings"
 * 1 rolling hash
 * 2 sliding window
 * 3 avoid overflow
 */
public class RabinKarp {

    private static int prime = 31;

    // rolling hash: sum(str[i] * prime^i)
    private static long createHash(String s) {
        long ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans += s.charAt(i) * Math.pow(prime, i);
        }

        return ans;
    }

    private static boolean isSame(String candidate, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            if (candidate.charAt(i) != pattern.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    // rabinkarp: use hash function to get the hash value of substring.
    // If the hash value is same, then check whether the substring is same
    // time: O(m)
    // space: O(1)

    private static int rabinkarp(String text, String pattern) {
        int m = text.length();
        int n = pattern.length();
        long patternHash = createHash(pattern);
        long textHash = createHash(text.substring(0, n - 1)); // add text[0, n - 2]

        for (int i = 0; i < m - n + 1; i++) {
            // add the last character text[n - 1]
            textHash += text.charAt(i + n - 1) * (long)Math.pow(prime, n - 1);

            // check the two conditions
            if (textHash == patternHash && isSame(text.substring(i, i + n), pattern)) {
                return i;
            }

            // remove the first character text[i] and update textHash
            textHash -= text.charAt(i) * (long)Math.pow(prime, 0);
            textHash /= prime;
        }

        return -1;
    }

    // 在给定text中查找是否存在某个substring == pattern
    // time: O(n)
    // space: O(1)
    public static void main(String[] args) {
        String text = "abcxabcdabcdabcy";
        String pattern = "abcdabcy";

        System.out.println(rabinkarp(text, pattern));
    }
}
