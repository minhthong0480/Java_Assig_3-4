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

        //enrolment.viewCourse();
        //enrolment.viewStudent();
        //enrolment.viewSem();

    }
}

//    FileWriter file = null;
//        try {
//                file = new FileWriter("src/allCouOfferedInSem.csv");
//                file.append("\n");
//                Iterator<Course> it = course.iterator();
//        file.append("All of the course offered in semester " + semester);
//        while(it.hasNext())
//        {
//        Course c = (Course)it.next();
//        file.append(c.getId());
//        file.append(",");
//        file.append(c.getName());
//        file.append(",");
//        file.append(String.valueOf(c.getCredits()));
//        file.append(",");
//        file.append("\n");
//        }
//
//        file.close();
//        } catch(Exception e){
//        e.printStackTrace();
//        }