package Graph.Matching;


import java.util.Arrays;

// https://www.geeksforgeeks.org/stable-marriage-problem/
public class GaleShapley {
    private static boolean woman_prefer_other(int[][] prefer, int woman, int cur, int other) {
        for (int i = 0; i < prefer[woman].length; i++) {
            if (prefer[woman][i] == other) {
                return true;
            } else if (prefer[woman][i] == cur) {
                return false;
            }
        }
        return false;
    }

    private static int[] stableMarriage(int[][] prefer) {
        int n = prefer.length / 2;
        int[] woman_man = new int[n];
        Arrays.fill(woman_man, -1);
        boolean[] free_man = new boolean[n];
        Arrays.fill(free_man, true);
        int free_count = n;

        while(free_count > 0) {
            int i = 0;
            for (i = 0; i < n; i++) {
                if (free_man[i]) {
                    break;
                }
            }

            for (int j = 0; j < prefer[i].length; j++) {
                int woman = prefer[i][j] - n;
                if (woman_man[woman] == -1) {
                    woman_man[woman] = i;
                    free_man[i] = false;
                    free_count--;
                    break;
                } else {
                    int other = woman_man[woman];
                    if (woman_prefer_other(prefer, woman + n, i, other)) {
                        continue;
                    } else {
                        woman_man[woman] = i;
                        free_man[i] = false;
                        free_man[other] = true;
                    }
                }
            }
        }

        return woman_man;
    }

    public static void main(String[] args) {
        int[][] prefer = {
                // man - woman
                {7, 5, 6, 4},
                {5, 4, 6, 7},
                {4, 5, 6, 7},
                {4, 5, 6, 7},
                // woman - man
                {0, 1, 2, 3},
                {0, 1, 2, 3},
                {0, 1, 2, 3},
                {0, 1, 2, 3}
        };

        int[] woman_man = stableMarriage(prefer);
        for (int i = 0; i < woman_man.length; i++) {
            System.out.println("woman: " + (i + woman_man.length) + " - man: " + woman_man[i]);
        }
    }
}
