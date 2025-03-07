package edu.trincoll;
public interface List {
    void insert(Job it);          // Insert an element at the end of the list
    void remove(Job it);          // Remove all occurrences of an element
    void display();               // Display all elements in the list
    void skip_display(int n);     // Skip first n elements and display the rest
    void reverse();               // Display elements in reverse order
    void remove_duplicates();     // Remove duplicate elements
}
