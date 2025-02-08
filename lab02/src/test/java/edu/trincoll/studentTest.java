package edu.trincoll;

import static org.junit.jupiter.api.Assertions.assertEquals;
// import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class studentTest {

    /**
     * Test case for constructor and accessor methods.
     */
    @Test
    public void testStudentConstructorAndAccessors() {
        student student = new student("John Doe", 20, 85.5);

        assertEquals("John Doe", student.getName());
        assertEquals(20, student.getAge());
        assertEquals(85.5, student.getGrade(), 0.001);
    }

    /**
     * Test case for mutator methods.
     */
    @Test
    public void testMutatorMethods() {
        student student = new student("Jane Doe", 22, 75.0);

        student.setName("Jane Smith");
        student.setAge(23);
        student.setGrade(90.2);

        assertEquals("Jane Smith", student.getName());
        assertEquals(23, student.getAge());
        assertEquals(90.2, student.getGrade(), 0.001);
    }
    
    @Test
    public void testFail() {
        student student = new student("John Doe", 20, 45.5);

        assertEquals("John Doe", student.getName());
        assertEquals(20, student.getAge());
        assertEquals(45.5, student.getGrade(), 0.001);
        assertEquals(false, student.getPassFail());        
    }
    
    // @Test
    // public void testPass() {
    //    // TODO: Create a Student object using the constructor. Grade should be > 50.   
    //    // TODO: Test for pass condition with “assertEquals(true, student.getPassFail())” similar to the one shown in to public void testFail()
    // }

}
