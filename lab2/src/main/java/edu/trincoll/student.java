package edu.trincoll;
/**
 * The Student class represents a student with a name, age, and grade.
 */
public class student {

    private String name;
    private int age;
    private double grade;
    private boolean pass_fail;

    /**
     * Constructor with parameters to initialize the student.
     *
     * @param name      The name of the student.
     * @param age       The age of the student.
     * @param grade     The grade of the student.
     * @param pass_fail Pass/Fail status of the student based on grade.
     */
    public student(String nameIn, int ageIn, double gradeIn) {
        name = nameIn;
        age = ageIn;
        grade = gradeIn;

        if (grade > 50) {
            pass_fail = true;
        } else {
            pass_fail = false;
        }
    }

    /**
     * Accessor method to get the name of the student.
     *
     * @return The name of the student.
     */
    public String getName() {
        return name;
    }

    /**
     * Accessor method to get the age of the student.
     *
     * @return The age of the student.
     */
    public int getAge() {
        return age;
    }

    /**
     * Accessor method to get the grade of the student.
     *
     * @return The grade of the student.
     */
    public double getGrade() {
        return grade;
    }

    /**
     * Accessor method to get the pass_fail of the student.
     *
     * @return The pass_fail status of the student.
     */
    public boolean getPassFail() {
        return pass_fail;
    }

    /**
     * Mutator method to set a new name for the student.
     *
     * @param newName The new name for the student.
     */
    public void setName(String newName) {
        name = newName;
    }

    /**
     * Mutator method to set a new age for the student.
     *
     * @param newAge The new age for the student.
     */
    public void setAge(int newAge) {
        age = newAge;
    }

    /**
     * Mutator method to set a new pass_fail for the student. (Hint: public void
     * setPassFail(double newGrade))
     *
     * @param newGrade The new grade for the student.
     */
    public void setPassFail(double newGrade) {
        if (newGrade > 50) {
            pass_fail = true;
        } else {
            pass_fail = false;
        }
    }
    // newGrade > 50, pass_fail should be set to true, else false.

    /**
     * Mutator method to set a new grade for the student.
     *
     * @param newGrade The new grade for the student.
     */
    public void setGrade(double newGrade) {
        grade = newGrade;
        setPassFail(newGrade);
    }
    // setPassFail(newGrade);

    /**
     * Main method for testing the Student class.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        // Creating a Student object using the constructor
        student student1 = new student("John Doe", 20, 45.5);

        // Displaying initial information
        System.out.println("Initial Student Information:");
        System.out.println("Name: " + student1.getName());
        System.out.println("Age: " + student1.getAge());
        System.out.println("Grade: " + student1.getGrade());
        System.out.println("Pass/Fail: " + student1.getPassFail());
        System.out.println();

        // Using mutator methods to update information
        student1.setName("John Smith");
        student1.setAge(21);
        student1.setGrade(92.0);

        // Displaying updated information
        // To do: Complete this to print updated student information as shown in the
        // assignment
        System.out.println("Updated Student Information:");
        System.out.println("Name: " + student1.getName());
        System.out.println("Age: " + student1.getAge());
        System.out.println("Grade: " + student1.getGrade());
        System.out.println("Pass/Fail: " + student1.getPassFail());

    }
}
