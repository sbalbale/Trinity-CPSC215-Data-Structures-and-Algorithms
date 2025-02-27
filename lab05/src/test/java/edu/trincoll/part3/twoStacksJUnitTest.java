
package edu.trincoll.part3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class twoStacksJUnitTest {

    @Test
    public void testPushAndPop() {
        // Create an instance of twoStacks with a capacity of 5
        twoStacks<Integer> ts = new twoStacks<>(5);
        
        // Push elements onto both stacks
        ts.push1(10);
        ts.push1(20);
        ts.push2(30);
        ts.push2(40);
        
        // Pop elements from each stack and verify they match expected values
        assertEquals(20, ts.pop1(), "First popped element from stack1 should be 20");
        assertEquals(10, ts.pop1(), "Second popped element from stack1 should be 10");
        assertEquals(40, ts.pop2(), "First popped element from stack2 should be 40");
        assertEquals(30, ts.pop2(), "Second popped element from stack2 should be 30");
        
        // Verify stacks are empty
        assertNull(ts.pop1(), "Stack1 should be empty");
        assertNull(ts.pop2(), "Stack2 should be empty");
    }
    
    @Test
    public void testTopValue() {
        // Create an instance of twoStacks with a capacity of 5
        twoStacks<Integer> ts = new twoStacks<>(5);
        
        // Verify top values are null when stacks are empty
        assertNull(ts.topValue1(), "Top value of empty stack1 should be null");
        assertNull(ts.topValue2(), "Top value of empty stack2 should be null");
        
        // Push elements onto both stacks
        ts.push1(15);
        ts.push1(25);
        ts.push2(35);
        ts.push2(45);
        
        // Retrieve top values and verify they match expected values
        assertEquals(25, ts.topValue1(), "Top value of stack1 should be 25");
        assertEquals(45, ts.topValue2(), "Top value of stack2 should be 45");
        
        // Verify top values remain unchanged after checking
        assertEquals(25, ts.topValue1(), "Top value of stack1 should still be 25");
        assertEquals(45, ts.topValue2(), "Top value of stack2 should still be 45");
    }
    
    @Test
    public void testLength() {
        // Create an instance of twoStacks with a capacity of 5
        twoStacks<Integer> ts = new twoStacks<>(5);
        
        // Verify initial lengths are 0
        assertEquals(0, ts.length1(), "Initial length of stack1 should be 0");
        assertEquals(0, ts.length2(), "Initial length of stack2 should be 0");
        
        // Push elements onto both stacks
        ts.push1(10);
        ts.push1(20);
        ts.push1(30);
        ts.push2(40);
        ts.push2(50);
        
        // Verify lengths after pushing
        assertEquals(3, ts.length1(), "Length of stack1 should be 3");
        assertEquals(2, ts.length2(), "Length of stack2 should be 2");
        
        // Pop elements and verify lengths update
        ts.pop1();
        ts.pop2();
        
        assertEquals(2, ts.length1(), "Length of stack1 should be 2 after pop");
        assertEquals(1, ts.length2(), "Length of stack2 should be 1 after pop");
    }
    
    @Test
    public void testClear() {
        // Create an instance of twoStacks with a capacity of 5
        twoStacks<Integer> ts = new twoStacks<>(5);
        
        // Push elements onto both stacks
        ts.push1(10);
        ts.push1(20);
        ts.push2(30);
        ts.push2(40);
        
        // Verify lengths before clearing
        assertEquals(2, ts.length1(), "Length of stack1 should be 2 before clear");
        assertEquals(2, ts.length2(), "Length of stack2 should be 2 before clear");
        
        // Clear the stacks
        ts.clear();
        
        // Verify lengths after clearing
        assertEquals(0, ts.length1(), "Length of stack1 should be 0 after clear");
        assertEquals(0, ts.length2(), "Length of stack2 should be 0 after clear");
        
        // Verify top values are null after clearing
        assertNull(ts.topValue1(), "Top value of cleared stack1 should be null");
        assertNull(ts.topValue2(), "Top value of cleared stack2 should be null");
    }
    
    @Test
    public void testEmptyStacks() {
        // Create an instance of twoStacks with a capacity of 5
        twoStacks<Integer> ts = new twoStacks<>(5);
        
        // Verify both stacks are initially empty
        assertEquals(0, ts.length1(), "Initial length of stack1 should be 0");
        assertEquals(0, ts.length2(), "Initial length of stack2 should be 0");
        
        // Verify popping from empty stacks returns null
        assertNull(ts.pop1(), "Popping from empty stack1 should return null");
        assertNull(ts.pop2(), "Popping from empty stack2 should return null");
        
        // Verify top values of empty stacks are null
        assertNull(ts.topValue1(), "Top value of empty stack1 should be null");
        assertNull(ts.topValue2(), "Top value of empty stack2 should be null");
    }
}