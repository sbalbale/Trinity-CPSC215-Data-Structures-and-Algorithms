package edu.trincoll.part1;
public interface DQueue<E> {

	  void insertFirst(E obj);

	  void insertLast(E obj);

	  E removeFirst();

	  E removeLast();

	  int size();
	  
	  void truncate_first(int num);
	  void truncate_last(int num);
	}