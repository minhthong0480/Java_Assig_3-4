import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Enrolmanager enrolment = new Enrolmanager();
        //ArrayList studentlist = new ArrayList<>();
        enrolment.importFile("Java_Assig_3-4/default.csv");
        for(Student s: enrolment.getStudentList())
            System.out.println(s);
        for(Course c: enrolment.getCourseList())
            System.out.println(c);

        enrolment.add();
    }
}
