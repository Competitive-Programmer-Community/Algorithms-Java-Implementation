package Stack;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    static int count  = 0;
    static Map<Integer, Integer> map = new HashMap<>();
    public static int fibonacci(int num) {
        if (map.containsKey(num)) {
            return map.get(num);
        }
        if (num == 1 || num == 2) {
            return 1;
        } else {
            count++;
            for (int i = 0; i < count; i++) {
                System.out.print("-");
            }
            System.out.println(num);

            int sum =  fibonacci(num - 1) + fibonacci(num - 2);
            map.put(num, sum);
            return sum;
        }
    }


    public static void main(String[] args) {
        fibonacci(10);
    }
}
