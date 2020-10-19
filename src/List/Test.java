package List;


import List.LinkedList.LinkedList;
import List.ArrayList.ArrayList;


public class Test {
    public static void main(String[] args) {
//        ArrayList arraylist = new ArrayList();
//        arraylist.add(1);
//        arraylist.add(2);
//        arraylist.add(3);
//        arraylist.print();
//        arraylist.add(0, 0);
//        arraylist.print();
//        arraylist.remove(1);
//        arraylist.print();
//        arraylist.removeElement(0);
//        arraylist.print();
//        arraylist.get(0);
//        arraylist.set(1, 9);
//        arraylist.print();
//        System.out.println(arraylist.contains(8));

        LinkedList<Integer> linkedlist = new LinkedList<>();
        linkedlist.add(1);
        linkedlist.add(2);
        linkedlist.add(3);
        linkedlist.add(4);
        linkedlist.add(5);
        linkedlist.print();
        linkedlist.add(0, 5);
        linkedlist.print();
        linkedlist.remove(0);
        linkedlist.print();
    }

}
