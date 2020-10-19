public class BaseType {
    public static void baseType() {
        int a  = 0;
        Integer b = null;
        Integer c = new Integer(0);
        Integer d = 0;
        System.out.println(a == c);
        System.out.println(a == d);

        Integer x = 130;
        Integer y = 130;
        System.out.println(x == y);
        System.out.println(x.equals(y));

        String s = "123";
        System.out.println(Integer.parseInt(s));
        System.out.println(x.toString());

    }

    public static void main(String[] args) {
        baseType();
    }
}

