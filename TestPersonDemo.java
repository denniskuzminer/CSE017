public class TestPersonDemo {

    public static void main(String[] args) {

        Student student1 = new Student("Thorn McNally", "1754 Falcon Drive");
        student1.addCourseGrade("CSE017", 92);
        student1.addCourseGrade("CSE 340", 88);
        System.out.println("Student grades:");
        student1.printGrades();
        System.out.println("Average is " + student1.getAverageGrade());
        System.out.println();


        Teacher teacher1 = new Teacher("Arielle Carr", "Packard 200B");
        System.out.println(teacher1);
        String[] courses = {"CSE017", "CSE340", "CSE017"};
        for (int i = 0; i < courses.length; i++) {
            String course = courses[i];
            if(teacher1.addCourse(course))
                System.out.println(course + " added to teacher schedule.");
            else
                System.out.println(course + " cannot be added to teacher schedule.");
        }
        for(int i = 0; i < courses.length; i++) {
            String course = courses[i];
            if(teacher1.removeCourse(course))
                System.out.println(course + " removed from teacher schedule.");
            else
                System.out.println(course + " cannot be removed from teacher schedule.");
        }
    }
}