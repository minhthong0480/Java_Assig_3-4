import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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
    public void add() {
        Student s = null;
        do {
            System.out.println("Enter studentID: ");
            String studentID = scanner.nextLine();
            for (Student student : studentList) {
                if (studentID.equalsIgnoreCase(student.getStudentID())) {
                    s = student;
                    //System.out.println(s.getStudentName());
                }
            }
        } while (s == null);

        Course c = null;
        do{
            System.out.println("Enter CourseID: ");
            String courseID = scanner.nextLine();
            for (Course course : courseList){
                if (courseID.equalsIgnoreCase(course.getCourseID())){
                    c = course;
                    System.out.println(c.getCourseName());
                }
            }
        }while (c == null);

        String sem;
        do{
            System.out.println("Enter semester: ");
            sem = scanner.nextLine();
        }while(sem == null);

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
    public void delete() {
        Student s = null;
        do {
            System.out.println("Enter studentID: ");
            String studentID = scanner.nextLine();
            for (Student student : studentList) {
                if (studentID.equalsIgnoreCase(student.getStudentID())) {
                    s = student;
                    //System.out.println(s.getStudentName());
                }
            }
        } while (s == null);

        Course c = null;
        do{
            System.out.println("Enter CourseID: ");
            String courseID = scanner.nextLine();
            for (Course course : courseList){
                if (courseID.equalsIgnoreCase(course.getCourseID())){
                    c = course;
                    System.out.println(c.getCourseName());
                }
            }
        }while (c == null);

        String sem;
        do{
            System.out.println("Enter semester: ");
            sem = scanner.nextLine();
        }while(sem == null);

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
    public void getOne() {
        Student s = null;
        do {
            System.out.print("Enter studentID: ");
            String studentID = scanner.nextLine();
            for (Student student : studentList) {
                if (studentID.equalsIgnoreCase(student.getStudentID())) {
                    s = student;
                    //System.out.println(s.getStudentName());
                }
            }
        } while (s == null);

        Course c = null;
        do{
            System.out.print("Enter CourseID: ");
            String courseID = scanner.nextLine();
            for (Course course : courseList){
                if (courseID.equalsIgnoreCase(course.getCourseID())){
                    c = course;
                    System.out.println(c.getCourseName());
                }
            }
        }while (c == null);

        String sem;
        do{
            System.out.print("Enter semester: ");
            sem = scanner.nextLine();
        }while(sem == null);

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
    public void update() {
        Student s = null;
        boolean check = false;
        do {
            System.out.println("Enter studentID: ");
            String studentID = scanner.nextLine();
            //check if is there any student match data
            for (Student student : studentList) {
                if (studentID.equalsIgnoreCase(student.getStudentID())) {
                    s = student;
                    //System.out.println(s.getStudentName());
                }
            }
        } while (s == null);

        String sem;
        do {
            System.out.println("Enter semester: ");
            sem = scanner.nextLine();
        } while (sem == null);

        for (StudentEnrolment se : studentEnrolmentList) {
            if (se.getStudent().getStudentID().equalsIgnoreCase(s.getStudentID()) &&
                    se.getSemester().equalsIgnoreCase(sem)) {
                System.out.println(se.getCourse());
                check = true;
            }
        }
        if (!check)
            System.out.println("==> No match data.");

        System.out.println("What do you want to do: ");
        System.out.println("Option 1: Add Course ");
        System.out.println("Option 2: Delete ");
        System.out.print("Enter (1) or (2): ");
        String option = scanner.nextLine();

        Course c = null;
        switch (option) {
            case "1" -> {
                do {
                    System.out.println("Enter CourseID: ");
                    String courseID = scanner.nextLine();
                    for (Course course : courseList) {
                        if (courseID.equalsIgnoreCase(course.getCourseID())) {
                            c = course;
                            System.out.println(c.getCourseName());
                        }
                    }
                } while (c == null);
                //check entered course
                for (StudentEnrolment se : studentEnrolmentList) {
                    if (se.getStudent().getStudentID().equalsIgnoreCase(s.getStudentID()) &&
                            se.getSemester().equalsIgnoreCase(sem) &&
                            se.getCourse().getCourseID().equalsIgnoreCase(c.getCourseID())) {
                        System.out.println("Already enrolled");
                        return;
                    }
                }
                //add new data
                studentEnrolmentList.add(new StudentEnrolment(s, c, sem));
                System.out.println("Enroll succesfully");
            }
            case "2" -> {
                do {
                    System.out.println("Enter CourseID: ");
                    String courseID = scanner.nextLine();
                    for (Course course : courseList) {
                        if (courseID.equalsIgnoreCase(course.getCourseID())) {
                            c = course;
                            System.out.println(c.getCourseName());
                        }
                    }
                } while (c == null);
                for (StudentEnrolment se : studentEnrolmentList) {
                    if (se.getStudent().getStudentID().equalsIgnoreCase(s.getStudentID()) &&
                            se.getSemester().equalsIgnoreCase(sem) &&
                            se.getCourse().getCourseID().equalsIgnoreCase(c.getCourseID())) {
                        studentEnrolmentList.remove(se);
                        System.out.println("Delete successfully!!");
                        return;
                    }
                }
                System.out.println("Data does not exist");
            }
        }
    }

    //view all course for 1 student
    public void viewCourse(){
        //input student data
        Student s = null;
        do {
            System.out.print("Enter studentID: ");
            String studentID = scanner.nextLine();
            for (Student student : studentList) {
                if (studentID.equalsIgnoreCase(student.getStudentID())) {
                    s = student;
                    //System.out.println(s.getStudentName());
                }
            }
        } while (s == null);

        //input semester data
        String sem;
        do{
            System.out.print("Enter semester: ");
            sem = scanner.nextLine();
        }while(sem == null);

        //print all course for input student
        System.out.println("List of Course: ");
        for(StudentEnrolment se : studentEnrolmentList){
            if (se.getStudent().getStudentID().equalsIgnoreCase(s.getStudentID()) &&
                    se.getSemester().equalsIgnoreCase(sem)){
                System.out.println(se.getCourse());
            }
        }
    }

    public void viewStudent(){
        //input course data
        Course c = null;
        do{
            System.out.print("Enter CourseID: ");
            String courseID = scanner.nextLine();
            for (Course course : courseList){
                if (courseID.equalsIgnoreCase(course.getCourseID())){
                    c = course;
                    System.out.println(c.getCourseName());
                }
            }
        }while (c == null);

        //input semester data
        String sem;
        do{
            System.out.print("Enter semester: ");
            sem = scanner.nextLine();
        }while(sem == null);

        //print all student for input course
        System.out.println("List of student: ");
        for(StudentEnrolment se : studentEnrolmentList){
            if (se.getCourse().getCourseID().equalsIgnoreCase(c.getCourseID()) &&
                    se.getSemester().equalsIgnoreCase(sem)){
                System.out.println(se.getStudent());
            }
        }
    }

    public void viewSem() {
        //input semester data
        String sem;
        do {
            System.out.print("Enter semester: ");
            sem = scanner.nextLine();
        } while (sem == null);

        System.out.println("List of Course in Semester: ");
        for (StudentEnrolment se : studentEnrolmentList) {
            if (se.getSemester().equalsIgnoreCase(sem)) {
                System.out.println(se.getCourse());
            }
        }
    }
}
