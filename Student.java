import java.util.*;
@SuppressWarnings("unchecked")

public class Student extends Person
{
    private int numCourses;
    private String[] courses;
    private int[] grades;

    /**
     * Constructs a student
     * @param name Name
     * @param address Addy
     */
    public Student(String name, String address) {
        super(name, address);
        numCourses = 0;
        // Assumes that each course has a grade and that there can be no more than 30 courses
        courses = new String[30];
        grades = new int[30];
    }

    /**
     * Call on the super class to provide the toString()
     * @return Example: Student: Thorn McNally(1754 Falcon Drive)
     */
    public String toString() {
        return "Student: " + super.toString();
    }

    /**
     * Appends a course to the end of courses[]
     * @param course The course to append
     * @param grade The corresponding grade
     */
    public void addCourseGrade(String course, int grade) {
        // numCourses must be incremented
        numCourses++;
        // numCourses-1 is the index at which grade and course are added
        courses[numCourses-1] = course;
        grades[numCourses-1] = grade;

    }

    /**
     * Prints out all the grades in course[]
     */
    public void printGrades() {
        String classes = "";
        for(int i = 0; i < numCourses; i++) {
            // Just makes all of the classes into one long string
            classes = classes + courses[i] + ":" + grades[i] + " ";
        }
        System.out.println("Student: " + super.getName() + "(" + super.getAddress() + ") " + classes);
    }

    /**
     * Gets the average of all grades in grades[]
     * @return The average
     */
    public double getAverageGrade() {
        double sum = 0;
        for(int i = 0; i < numCourses; i++) {
            // Adds all the grades up
            sum += grades[i];
        }
        return sum/numCourses;
    }
}