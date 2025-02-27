package edu.trincoll.part1;

import java.io.*;
import java.util.Random;

/** A JUnit test class for stacks. */


public class StackTest {
  public static void main(String args[]) {
    Stack<Integer> S1;

    // S1 = new Stack<>();
    S1 = new AStack<Integer>();
    while (S1.length() < 10) {
      int temp = new Random().nextInt(100);
      System.out.println("Pushed value: " + temp);
      S1.push(temp);
    }
    System.out.println("Stack S1: " + S1);
    System.out.println("Length of S1: " + S1.length());
    System.out.println("Top value of S1: " + S1.topValue());
    while (S1.length() > 5) {
      System.out.println("Popped value: " + S1.pop());
    }
    System.out.println("Stack S1: " + S1);
    System.out.println("Length of S1: " + S1.length());

  }

}