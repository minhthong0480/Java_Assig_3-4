import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Enrolmanager implements StudentEnrolmentManager {
    private ArrayList<Student> studentList = new ArrayList<>();
    private ArrayList<Course> courseList = new ArrayList<>();
    private ArrayList<StudentEnrolment> studentEnrolmentList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);
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
        Scanner sc;
        try{
            sc = new Scanner(new File(fileName));
        }
        catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("File not found");
            sc = new Scanner(new File(fileName));
        }
        while(sc.hasNextLine()){
            //add student data to array list
            String line = sc.nextLine();
            String [] values = line.split(",");
            Student stu = new Student(values[0], values[1], values[2]);
            Course cou = new Course(values[3], values[4],Integer.parseInt(values[5]));

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
    public void add(Student s, Course c, String sem) {

        for(StudentEnrolment se: studentEnrolmentList){
            if(se.getStudent().getStudentID().equalsIgnoreCase(s.getStudentID()) &&
                se.getCourse().getCourseID().equalsIgnoreCase(c.getCourseID()) &&
                se.getSemester().equalsIgnoreCase(sem)){
                System.out.println("Already enrolled");
                return;
            }
        }
        studentEnrolmentList.add(new StudentEnrolment(s,c,sem));
        System.out.println("Enroll succesfully");
    }

    @Override
    public void delete(Student s, Course c, String sem) {

        for(StudentEnrolment se: studentEnrolmentList){
            if(se.getStudent().getStudentID().equalsIgnoreCase(s.getStudentID()) &&
                    se.getCourse().getCourseID().equalsIgnoreCase(c.getCourseID()) &&
                    se.getSemester().equalsIgnoreCase(sem)){
                studentEnrolmentList.remove(se);
                System.out.println("Delete successfully!!");
                return;
            }
        }
        System.out.println("Data does not exist");
    }

    @Override
    public void getOne(Student s, Course c, String sem) {

        for(StudentEnrolment se: studentEnrolmentList){
            if(se.getStudent().getStudentID().equalsIgnoreCase(s.getStudentID()) &&
                    se.getCourse().getCourseID().equalsIgnoreCase(c.getCourseID()) &&
                    se.getSemester().equalsIgnoreCase(sem)){
                System.out.println("====> "+se);
                return;
            }
        }
        System.out.println("Data does not exist");
    }

    @Override
    public void getAll() {
        System.out.println("List of Enrolment: ");
        for(StudentEnrolment se : studentEnrolmentList){
            System.out.println(se);
        }
    }

    @Override
    public void update(Student s, Course c, String sem, String opt) {
        switch(opt){
            case "1" -> {
                add(s,c,sem);
            }
            case "2" -> {
                delete(s,c,sem);
            }
        }
    }

    //view all course for 1 student
    public void viewCourse(Student s, String sem){

        //print all course for input student
        ArrayList<Course> tempCourseList = new ArrayList<>();
        System.out.println("List of Course: ");
        for(StudentEnrolment se : studentEnrolmentList){
            if (se.getStudent().getStudentID().equalsIgnoreCase(s.getStudentID()) &&
                    se.getSemester().equalsIgnoreCase(sem)){
                System.out.println(se.getCourse());
                tempCourseList.add(se.getCourse());
            }
        }

        //write to csv all course for 1 student
        FileWriter file = null;
        try {
            file = new FileWriter("Test.csv");
            file.append("\n");
            Iterator<Course> printCourseforStudent = tempCourseList.iterator();
            file.append("All of the course in semester \n" + sem);
            while(printCourseforStudent.hasNext())
            {
                Course c = (Course)printCourseforStudent.next();
                file.append(c.getCourseID());
                file.append(",");
                file.append(c.getCourseName());
                file.append(",");
                file.append(String.valueOf(c.getNumberofCredit()));
                file.append(",");
                file.append("\n");
                file.append("");
            }

            file.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void viewStudent(Course c, String sem){

        //print all student for input course
        ArrayList<Student> tempStudentList = new ArrayList<>();
        System.out.println("List of student: ");
        for(StudentEnrolment se : studentEnrolmentList){
            if (se.getCourse().getCourseID().equalsIgnoreCase(c.getCourseID()) &&
                    se.getSemester().equalsIgnoreCase(sem)){
                System.out.println(se.getStudent());
                tempStudentList.add(se.getStudent());
            }
        }

        FileWriter file = null;
        try {
            file = new FileWriter("Test.csv");
            file.append("\n");
            Iterator<Student> printStudentofOneCourse = tempStudentList.iterator();
            file.append("All of the course in semester \n" + sem);
            while(printStudentofOneCourse.hasNext())
            {
                Student s = (Student)printStudentofOneCourse.next();
                file.append(s.getStudentID());
                file.append(",");
                file.append(s.getStudentName());
                file.append(",");
                file.append(String.valueOf(s.getBirthDate()));
                file.append(",");
                file.append("\n");
                file.append("");
            }
            file.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void viewSem(String sem) {
        ArrayList<Course> tempCourseList = new ArrayList<>();
        System.out.println("List of Course in Semester: ");
        for (StudentEnrolment se : studentEnrolmentList) {
            if (se.getSemester().equalsIgnoreCase(sem)) {
                    System.out.println(se.getCourse());
                    tempCourseList.add(se.getCourse());
                }
            }

//write all course in one semester
        FileWriter file = null;
        try {
            file = new FileWriter("Test.csv");
            file.append("\n");
            Iterator<Course> printCourseInSem = tempCourseList.iterator();
            file.append("All of the course in semester \n" + sem);
            while(printCourseInSem.hasNext())
            {
                Course c = (Course)printCourseInSem.next();
                file.append(c.getCourseID());
                file.append(",");
                file.append(c.getCourseName());
                file.append(",");
                file.append(String.valueOf(c.getNumberofCredit()));
                file.append(",");
                file.append("\n");
                file.append("");
            }

            file.close();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

}
