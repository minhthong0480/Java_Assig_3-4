class Student{
    public String StudentID;
    public String StudentName;
    public String BirthDate;

    public Student(String StudentID, String StudentName, String BirthDate) {
        this.StudentID = StudentID;
        this.StudentName = StudentName;
        this.BirthDate = BirthDate;
    }
}

class Course{
    public String CourseID;
    public String CourseName;
    public int NumberofCredit;

    public Course(String CourseID, String CourseName, int NumberofCredit){
        this.CourseID = CourseID;
        this.CourseName = CourseName;
        this.NumberofCredit = NumberofCredit;
    }
}

class StudentEnrolment{
    public Student student;
    public Course course;
    public String semester;

    public StudentEnrolment(Student student, Course course, String semester){
        this.student = student;
        this.course = course;
        this.semester = semester;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
