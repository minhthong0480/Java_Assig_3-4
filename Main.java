import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Enrolmanager enrolment = new Enrolmanager();
        //ArrayList studentlist = new ArrayList<>();
        enrolment.importFile("default.csv");

//        for(Student s: enrolment.getStudentList())
//            System.out.println(s);
//        for(Course c: enrolment.getCourseList())
//            System.out.println(c);

        //enrolmenuestionCourse();
        //enrolment.viewStudent();
        //enrolment.viewSem();

    }
}

