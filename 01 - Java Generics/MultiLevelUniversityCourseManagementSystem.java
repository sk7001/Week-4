import java.util.ArrayList;
import java.util.List;

abstract class CourseType {
    String courseName;
    String instructor;
    CourseType(String courseName, String instructor) {
        this.courseName = courseName;
        this.instructor = instructor;
    }
    abstract void evaluate();
    void display() {
        System.out.println(courseName + " by " + instructor);
        evaluate();
    }
}

class ExamCourse extends CourseType {
    ExamCourse(String courseName, String instructor) { super(courseName, instructor); }
    @Override void evaluate() { System.out.println("Evaluation: Final Exam"); }
}

class AssignmentCourse extends CourseType {
    AssignmentCourse(String courseName, String instructor) { super(courseName, instructor); }
    @Override void evaluate() { System.out.println("Evaluation: Weekly Assignments"); }
}

class ResearchCourse extends CourseType {
    ResearchCourse(String courseName, String instructor) { super(courseName, instructor); }
    @Override void evaluate() { System.out.println("Evaluation: Research Project"); }
}

class Course<T extends CourseType> {
    List<T> courseList = new ArrayList<>();
    void addCourse(T course) { courseList.add(course); }
    void showAllCourses() { for (T course : courseList) course.display(); }
    static void displayAnyCourseList(List<? extends CourseType> courses) {
        for (CourseType course : courses) course.display();
    }
}

public class MultiLevelUniversityCourseManagementSystem {
    public static void main(String[] args) {
        Course<ExamCourse> examCourses = new Course<>();
        examCourses.addCourse(new ExamCourse("Mathematics", "Dr. Sharma"));
        examCourses.addCourse(new ExamCourse("Physics", "Dr. Reddy"));

        Course<AssignmentCourse> assignmentCourses = new Course<>();
        assignmentCourses.addCourse(new AssignmentCourse("English", "Ms. Meera"));
        assignmentCourses.addCourse(new AssignmentCourse("History", "Mr. Jacob"));

        Course<ResearchCourse> researchCourses = new Course<>();
        researchCourses.addCourse(new ResearchCourse("AI Thesis", "Dr. Bose"));
        researchCourses.addCourse(new ResearchCourse("Quantum Research", "Dr. Patel"));

        System.out.println("Exam-Based Courses:");
        examCourses.showAllCourses();

        System.out.println("\nAssignment-Based Courses:");
        assignmentCourses.showAllCourses();

        System.out.println("\nResearch-Based Courses:");
        researchCourses.showAllCourses();

        System.out.println("\nDisplaying All Courses using Wildcards:");
        Course.displayAnyCourseList(examCourses.courseList);
        Course.displayAnyCourseList(assignmentCourses.courseList);
        Course.displayAnyCourseList(researchCourses.courseList);
    }
}
