package String;

import java.util.HashMap;

/**
 * test String related functions
 */
public class Test {

    public static void main(String[] args) {
        String s = "a bc";
        String t = new String("a bc");

        Integer i = new Integer(1);
        Integer j = 2;
        s.length();
        s.equals(t);

        System.out.println(s == t);
        System.out.println(s.substring(1));
        System.out.println(s.substring(1, 2));

        System.out.println(s.indexOf("bc"));
        System.out.println(s.indexOf("x"));
        System.out.println(s.lastIndexOf("c"));
        System.out.println(s.startsWith("a"));
        System.out.println(s.startsWith("b"));

        System.out.println(s.toCharArray().toString());
        System.out.println(s.charAt(0));
        System.out.println(s.split(" "));
        System.out.println(s.trim());


        String temp = "  // variable declaration ";
        System.out.println(temp.trim().startsWith("//"));
    }
}

