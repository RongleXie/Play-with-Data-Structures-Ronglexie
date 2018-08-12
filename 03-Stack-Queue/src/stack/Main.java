package stack;

import queue.Queue;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int count = 10000000;

        ArrayStack<Integer> arrayStack = new ArrayStack<>();

        System.out.println("ArrayStack: "+testStack(arrayStack,count)+"s");

        LinkedListStack linkedListStack = new LinkedListStack();

        System.out.println("LinkedListStack"+testStack(linkedListStack,count)+"s");
    }


    private static double testStack(Stack<Integer> stack, int count){
        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < count; i++) {
            int nextInt = random.nextInt(Integer.MAX_VALUE);
            stack.push(nextInt);
        }
        for (int i = 0; i < count; i++) {
            stack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime)/1000000000.0;
    }
}
