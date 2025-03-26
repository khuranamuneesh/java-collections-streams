import java.util.*;

abstract class CourseType {
    private String courseName;

    public CourseType(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return "Course: " + courseName;
    }
}

// Specific types of courses
class ExamCourse extends CourseType {
    public ExamCourse(String courseName) {
        super(courseName);
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse(String courseName) {
        super(courseName);
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse(String courseName) {
        super(courseName);
    }
}

// Generic class to manage courses
class Course<T extends CourseType> {
    private T courseType;
    private String department;

    public Course(T courseType, String department) {
        this.courseType = courseType;
        this.department = department;
    }

    public T getCourseType() {
        return courseType;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return courseType + " (Department: " + department + ")";
    }
}

// Utility class to display any type of course dynamically
class CourseUtility {
    public static void displayCourses(List<? extends CourseType> courses) {
        for (CourseType course : courses) {
            System.out.println(course);
        }
    }
}

public class MultiLevelUniCourseManagementSystem {
    public static void main(String[] args) {
        // Creating courses for different evaluation types
        Course<ExamCourse> javaCourse = new Course<>(new ExamCourse("Java"), "Computer Science");
        Course<AssignmentCourse> dsaCourse = new Course<>(new AssignmentCourse("Data Structures & Algorithms"), "Computer Science");
        Course<ResearchCourse> backendCourse = new Course<>(new ResearchCourse("Backend Development"), "Software Engineering");

        // Storing courses in a list
        List<CourseType> courseList = new ArrayList<>();
        courseList.add(javaCourse.getCourseType());
        courseList.add(dsaCourse.getCourseType());
        courseList.add(backendCourse.getCourseType());

        // Displaying all courses dynamically
        System.out.println("University Courses:");
        CourseUtility.displayCourses(courseList);
    }
}

