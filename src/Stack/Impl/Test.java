package Stack.Impl;

import java.util.Stack;

public class Test {
    private static void testArrayStack() {
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        arrayStack.push(1);
        arrayStack.print();
        for (int i = 0; i < 10; i++) {
            arrayStack.push(i);
        }

        System.out.println(arrayStack.peek());
        arrayStack.print();
        arrayStack.pop();
        arrayStack.print();
    }

    private static void testLinkedListStack() {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        linkedListStack.push(1);
        linkedListStack.print();
        for (int i = 0; i < 10; i++) {
            linkedListStack.push(i);
        }

        System.out.println(linkedListStack.peek());
        linkedListStack.print();
        linkedListStack.pop();
        linkedListStack.print();
    }

    private static void testBuiltInStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }

    public static void main(String[] args){
        testArrayStack();
        testLinkedListStack();
        testBuiltInStack();
    }

}

