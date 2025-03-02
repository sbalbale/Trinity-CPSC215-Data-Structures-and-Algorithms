package edu.trincoll.part1;
public class DLDTest {
	public static void main(String args[]) {
		DQueue<Integer> q1 = new DLDQueue<Integer>();
		System.out.println("Inserting 5 elements at the begining of Queue");
		q1.insertFirst(10);
		q1.insertFirst(30);
		q1.insertFirst(50);
		q1.insertFirst(70);
		q1.insertFirst(90);
		System.out.println("Inserting 5 elements at the end of Queue");
		q1.insertLast(40);
		q1.insertLast(20);
		q1.insertLast(60);
		q1.insertLast(80);
		q1.insertLast(100);
		System.out.println("Current size :"+q1.size());
		System.out.println("Printing Queue :"+q1);
		System.out.println("Removing 1 element from beginning and end of Queue");
		q1.removeFirst();
		q1.removeLast();
		System.out.println("Current size :"+q1.size());
		System.out.println("Printing Queue :"+q1);
		System.out.println("Removing 1 element from beginning and end of Queue");
		q1.removeFirst();
		q1.removeLast();
		System.out.println("Inserting 4 elements at the beginning and end of Queue");
		q1.insertFirst(10);
		q1.insertLast(20);
		q1.insertFirst(30);
		q1.insertLast(40);
		q1.insertFirst(50);
		q1.insertLast(60);
		q1.insertFirst(70);
		q1.insertLast(80);
		System.out.println("Printing Queue :"+q1);
		System.out.println("Truncating the list from First");
		q1.truncate_first(2);
		System.out.println("Truncating the list from Last");
		q1.truncate_last(2);
		System.out.println("Printing Queue :"+q1);
	}

}