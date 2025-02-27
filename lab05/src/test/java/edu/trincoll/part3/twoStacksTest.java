package edu.trincoll.part3;
// Class twoStacksTest
public class twoStacksTest {
    public static void main(String[] args) {
        int size = 15;
        System.out.println("Creating two stacks within an array of size: " + size);
        twoStacks<Integer> ts = new twoStacks<>(size);
        
        System.out.println("Pushing elements to Stack 1");
        ts.push1(5);
        ts.push1(11);
        ts.push1(1);
        ts.push1(2);
        ts.push1(3);

        System.out.println("Peeking top value in Stack 1: " + ts.topValue1());
        System.out.println("Length of Stack 1: " + ts.length1());

        System.out.println("Pushing elements to Stack 2");
        ts.push2(10);
        ts.push2(15);
        ts.push2(7);
        ts.push2(40);

        System.out.println("Peeking top value in Stack 2: " + ts.topValue2());
        System.out.println("Length of Stack 2: " + ts.length2());

        System.out.println("Popped element from stack 1: " + ts.pop1());
        System.out.println("Popped element from stack 1: " + ts.pop1());

        System.out.println("Popped element from stack 2: " + ts.pop2());
        System.out.println("Popped element from stack 2: " + ts.pop2());

        System.out.println("Length of Stack 1: " + ts.length1());
        System.out.println("Length of Stack 2: " + ts.length2());
    }
}