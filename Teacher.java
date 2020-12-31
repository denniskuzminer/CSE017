import java.util.*;

public class Teacher extends Person
{
    private int numCourses;
    private String[] courses;

    /**
     * Constucts Teacher
     * @param name Name
     * @param address Address
     */
    public Teacher(String name, String address) {
        super(name, address);
        // A teacher by default will not be able to have more than 30 courses
        // and will start out with zero courses
        numCourses = 0;
        courses = new String[30];
    }

    /**
     * Adds a course to courses[]
     * @param course Course to add to the end of courses[]
     * @return If the course is already in the array the it will return false
     * This pretty much means you can't have duplicates of classes in the same array
     */
    public boolean addCourse(String course) {
        // Loops through the array to see if the course is already there
        // If it is, then it will return false and nothing else
        for(int i = 0; i < courses.length; i++) {
            if(course.equals(courses[i]))
                return false;
        }
        // If it passes through at this point return true
        // Add 1 to num courses
        // And make the last course in the list equal to the user's course
        numCourses++;
        courses[numCourses-1] = course;

        return true;
    }

    /**
     * Removes a course from the list
     * @param course Course to remove
     * @return If the course is found in the array, then returns true
     */
    public boolean removeCourse(String course) {
        // If the course is in the array, then it will "remove" the course by setting it to null
        for(int i = 0; i < courses.length; i++) {
            if(course.equals(courses[i])) {
                courses[i] = null;
                /*
                Then after the course is removed, this for look will take all of the
                elements after the removed element and stift them back by 1 index.
                This will make the array continuous as opposed to having "holes" (idk thats the best i can explain it)
                 */
                for(int j = i; j < courses.length-1; j++){
                    // Moves the elements after the removed element back 1
                    courses[j] = courses[j+1];
                }
                return true;
            }
        }
        return false;

    }
}