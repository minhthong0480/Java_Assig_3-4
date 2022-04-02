import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Enrolmanager enrollment = new Enrolmanager();
        //ArrayList studentlist = new ArrayList<>();
        enrollment.importFile("default.csv");

        for(Student s: enrollment.getStudentList())
            System.out.println(s);
        for(Course c: enrollment.getCourseList())
            System.out.println(c);

        //enrolmenuestionCourse();
        //enrolment.viewStudent();
        //enrolment.viewSem();

        Menu menu = new Menu();
        menu.createMenu();

    }
}

