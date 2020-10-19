package Queue;


import java.util.LinkedList;
import java.util.Queue;

public class Test {
    public static void testLinkedListOfQueueImpl() {
        IQueue<Integer> queue = new QueueOfLinkedList<>();
        for (int i = 0; i < 8; i++) {
            queue.offer(i);
        }
        queue.print();

        queue.poll();
        queue.print();
        System.out.println(queue.peek());
    }

    public static void testArrayOfQueueImpl() {
        IQueue<Integer> queue = new QueueOfArray<>();
        for (int i = 0; i < 11; i++) {
            queue.offer(i);
        }
        queue.print();

        queue.poll();
        queue.print();
        System.out.println(queue.peek());
    }

    public static void testCircularArrayOfQueueImpl() {
        IQueue<Integer> queue = new QueueOfCircularArray<>();
        for (int i = 0; i < 11; i++) {
            queue.offer(i);
        }
        queue.print();

        queue.poll();
        queue.print();
        System.out.println(queue.peek());
    }

    public static void testBuiltInQueue() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            queue.offer(i);
        }

        System.out.println(queue.size());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }

    public static void main(String[] args) {
        testLinkedListOfQueueImpl();
        testArrayOfQueueImpl();
        testCircularArrayOfQueueImpl();
        testBuiltInQueue();
    }
}

