import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Enrolmanager implements StudentEnrolmentManager {
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Course> courseList = new ArrayList<>();
    private ArrayList<StudentEnrolment> studentEnrolmentList = new ArrayList<>();

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(ArrayList<Course> courseList) {
        this.courseList = courseList;
    }

    public ArrayList<StudentEnrolment> getStudentEnrolmentList() {
        return studentEnrolmentList;
    }

    public void setStudentEnrolmentList(ArrayList<StudentEnrolment> studentEnrolmentList) {
        this.studentEnrolmentList = studentEnrolmentList;
    }

    //String path ="/Users/thongnguyen/Documents/GitHub/Java_Assig_3-4/default.csv";

    public void importFile(String fileName) throws FileNotFoundException {
        Scanner scanner;
        try{
            scanner = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("File not found");
            scanner = new Scanner(new File(fileName));
        }
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String [] values = line.split(",");
            Student stu = new Student(values[0], values[1], values[2]);
            Course cou = new Course(values[3], values[4],Integer.parseInt(values[5]));
//            Test duplicate studentID
//            for(Student s : studentList){
//                if(!((s.getStudentID()).equalsIgnoreCase(stu.getStudentID()))) {
//                    studentList.add(stu);
//                }
//            }
            if(stuIsNotDup(stu)) {
                studentList.add(stu);
            }

            if(couIsNotDup(cou)) {
                courseList.add(cou);
            }

            studentEnrolmentList.add(new StudentEnrolment(new Student(values[0], values[1], values[2]),
                    new Course(values[3], values[4],Integer.parseInt(values[5])), values[6]));
        }
    }
//check student duplicate
    public boolean stuIsNotDup(Student student){
        for(Student s : studentList){
            if(((s.getStudentID()).equalsIgnoreCase(student.getStudentID()))) {
                return false;
            }
        }
        return true;
    }

//check course duplicate
    public boolean couIsNotDup(Course course){
        for(Course s : courseList){
            if(((s.getCourseID()).equalsIgnoreCase(course.getCourseID()))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void add() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void getOne() {

    }

    @Override
    public void getAll() {

    }
}
