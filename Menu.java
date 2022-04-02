import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Menu {
    public Menu() {
    }

    public void createMenu() throws FileNotFoundException {
        Student s = null;
        Course c = null;
        String studentID,courseID,sem, opt;

        Enrolmanager enroll = new Enrolmanager();

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your file's name: ");
        enroll.importFile(input.nextLine());

        do {

            // Main menu
            do {
                System.out.println("Please choose one option: ");
                System.out.println("Option 1: Add new Student.");
                System.out.println("Option 2: Update Student Data.");
                System.out.println("Option 3: Delete Student.");
                System.out.println("Option 4: Get Data of One Student.");
                System.out.println("Option 5: Get Data All Student.");
                System.out.println("Option 6: Print Courses for Student in one Semester");
                System.out.println("Option 7: Print all Student of one Course.");
                System.out.println("Option 8: Print all Course offered in one Semester");
                System.out.println("Option 9: Exit");
                System.out.print("Enter your option: ");
                opt = input.nextLine();

            } while ((!opt.equals("1")) && (!opt.equals("2"))
                    && (!opt.equals("3")) && (!opt.equals("4")) && (!opt.equals("5")) && (!opt.equals("6"))
                    && (!opt.equals("7")) && (!opt.equals("8")) && (!opt.equals("9")));

            // Check option is valid or not
            if ((Integer.parseInt(opt) >= 1)
                    && (Integer.parseInt(opt) <= 9)) {
                switch (opt) {
                    case "1": // Enroll
                        do {
                            System.out.println("Enter studentID: ");
                            studentID = input.nextLine();
                            for (Student student : enroll.getStudentList()) {
                                if (studentID.equalsIgnoreCase(student.getStudentID())) {
                                    s = student;
                                    //System.out.println(s.getStudentName());
                                }
                            }
                        } while (s == null);

                        do {
                            System.out.println("Enter CourseID: ");
                            courseID = input.nextLine().toUpperCase();
                            for (Course course : enroll.getCourseList()) {
                                if (courseID.equalsIgnoreCase(course.getCourseID())) {
                                    c = course;
                                    //System.out.println(c.getCourseName());
                                }
                            }
                        } while (c == null);

                        do {
                            System.out.println("Enter semester: ");
                            sem = input.nextLine();
                        } while (sem == null);

                        enroll.add(s,c,sem);
                        enroll.getAll();
                        break;

                    case "2": // Update

                        boolean check = false;
                        do {
                            System.out.println("Enter studentID: ");
                            studentID = input.nextLine();
                            //check if is there any student match data
                            for (Student student : enroll.getStudentList()) {
                                if (studentID.equalsIgnoreCase(student.getStudentID())) {
                                    s = student;
                                    //System.out.println(s.getStudentName());
                                }
                            }
                        } while (s == null);

                        do {
                            System.out.println("Enter semester: ");
                            sem = input.nextLine();
                        } while (sem == null);

                        for (StudentEnrolment se : enroll.getStudentEnrolmentList()) {
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
                        String option = input.nextLine();

                        switch (option) {
                            case "1" -> {
                                do {
                                    System.out.println("Enter CourseID: ");
                                    courseID = input.nextLine();
                                    for (Course course : enroll.getCourseList()) {
                                        if (courseID.equalsIgnoreCase(course.getCourseID())) {
                                            c = course;
                                            System.out.println(c.getCourseName());
                                        }
                                    }
                                } while (c == null);
                                //check entered course
                                enroll.update(s, c, sem, opt);

                                for (StudentEnrolment se : enroll.getStudentEnrolmentList()) {
                                    if (se.getStudent().getStudentID().equalsIgnoreCase(s.getStudentID()) &&
                                            se.getSemester().equalsIgnoreCase(sem) &&
                                            se.getCourse().getCourseID().equalsIgnoreCase(c.getCourseID())) {
                                        System.out.println("Already enrolled");
                                        return;
                                    }
                                }
                                //add new data
                                enroll.getStudentEnrolmentList().add(new StudentEnrolment(s, c, sem));
                                System.out.println("Enroll succesfully");
                                break;
                            }
                            case "2" -> {
                                do {
                                    System.out.println("Enter CourseID: ");
                                    courseID = input.nextLine();
                                    for (Course course : enroll.getCourseList()) {
                                        if (courseID.equalsIgnoreCase(course.getCourseID())) {
                                            c = course;
                                            System.out.println(c.getCourseName());
                                        }
                                    }
                                } while (c == null);
                                for (StudentEnrolment se : enroll.getStudentEnrolmentList()) {
                                    if (se.getStudent().getStudentID().equalsIgnoreCase(s.getStudentID()) &&
                                            se.getSemester().equalsIgnoreCase(sem) &&
                                            se.getCourse().getCourseID().equalsIgnoreCase(c.getCourseID())) {
                                        enroll.getStudentEnrolmentList().remove(se);
                                        System.out.println("Delete successfully!!");
                                        return;
                                    }
                                }
                                System.out.println("Data does not exist");
                                break;
                            }
                        }
                    case "3": // Delete
                        do {
                            System.out.println("Enter studentID: ");
                            studentID = input.nextLine();
                            for (Student student : enroll.getStudentList()) {
                                if (studentID.equalsIgnoreCase(student.getStudentID())) {
                                    s = student;
                                    //System.out.println(s.getStudentName());
                                }
                            }
                        } while (s == null);

                        do{
                            System.out.println("Enter CourseID: ");
                            courseID = input.nextLine();
                            for (Course course : enroll.getCourseList()){
                                if (courseID.equalsIgnoreCase(course.getCourseID())){
                                    c = course;
                                    System.out.println(c.getCourseName());
                                }
                            }
                        }while (c == null);

                        do{
                            System.out.println("Enter semester: ");
                            sem = input.nextLine();
                        }while(sem == null);

                        enroll.delete(s,c,sem);
                        break;

                    case "4": //get one
                        do {
                            System.out.print("Enter studentID: ");
                            studentID = input.nextLine();
                            for (Student student : enroll.getStudentList()) {
                                if (studentID.equalsIgnoreCase(student.getStudentID())) {
                                    s = student;
                                    //System.out.println(s.getStudentName());
                                }
                            }
                        } while (s == null);

                        do{
                            System.out.print("Enter CourseID: ");
                            courseID = input.nextLine();
                            for (Course course : enroll.getCourseList()){
                                if (courseID.equalsIgnoreCase(course.getCourseID())){
                                    c = course;
                                    System.out.println(c.getCourseName());
                                }
                            }
                        }while (c == null);

                        do{
                            System.out.print("Enter semester: ");
                            sem = input.nextLine();
                        }while(sem == null);

                        enroll.getOne(s,c,sem);
                        break;

                    case "5": //get all
                        enroll.getAll();
                        break;

                    case "6":
                        do {
                            System.out.print("Enter studentID: ");
                            studentID = input.nextLine();
                            for (Student student : enroll.getStudentList()) {
                                if (studentID.equalsIgnoreCase(student.getStudentID())) {
                                    s = student;
                                    //System.out.println(s.getStudentName());
                                }
                            }
                        } while (s == null);

                        //input semester data
                        do{
                            System.out.print("Enter semester: ");
                            sem = input.nextLine();
                        }while(sem == null);

                        enroll.viewCourse(s,sem);
                        break;

                    case "7":
                        do{
                            System.out.print("Enter CourseID: ");
                            courseID = input.nextLine();
                            for (Course course : enroll.getCourseList()){
                                if (courseID.equalsIgnoreCase(course.getCourseID())){
                                    c = course;
                                    System.out.println(c.getCourseName());
                                }
                            }
                        }while (c == null);

                        //input semester data
                        do{
                            System.out.print("Enter semester: ");
                            sem = input.nextLine();
                        }while(sem == null);

                        enroll.viewStudent(c,sem);
                        break;

                    case "8":
                        do {
                            System.out.print("Enter semester: ");
                            sem = input.nextLine();
                        } while (sem == null);

                        enroll.viewSem(sem);
                        break;

                    case "9":
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + opt);
                }
            }

            // If option is not 1 - 9
            else {
                System.out.println("Invalid Option!");
                System.out.println("----------------------------------------------");
            }
        } while (!opt.equals("1") && !opt.equals("2") && !opt.equals("3")
                && !opt.equals("4") && !opt.equals("5") && !opt.equals("6")
                && !opt.equals("7") && !opt.equals("8") && !opt.equals("9"));
    }
}
