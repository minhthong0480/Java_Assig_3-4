import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;

class EnrolmentManagerTest {

    private static Enrolmanager enrollmana = new Enrolmanager();

    @BeforeAll
    static void beforeAll() throws FileNotFoundException {
        enrollmana.importFile("default.csv");

    }

    @Test
    void testAdd() {
        //Successful Test Case
        String studID = "s101312";
        String couID = "COSC3321";
        String sem = "2020C";
        Student s = null;
        Course c = null;
        StudentEnrolment studEnrol = null;
//        for (Student student : enrollmana.getStudentList()) {
//            if (studID.equalsIgnoreCase(student.getStudentID())) {
//                s = student;
//                //System.out.println(s.getStudentName());
//            }
//        }
//        for (Course course : enrollmana.getCourseList()) {
//            if (couID.equalsIgnoreCase(course.getCourseID())) {
//                c = course;
//                //System.out.println(s.getStudentName());
//            }
//        }
//
//        enrollmana.add(s, c, sem);
//
//        for(StudentEnrolment se: enrollmana.getStudentEnrolmentList()){
//            if(se.getStudent().getStudentID().equalsIgnoreCase(s.getStudentID()) &&
//                    se.getCourse().getCourseID().equalsIgnoreCase(c.getCourseID()) &&
//                    se.getSemester().equalsIgnoreCase(sem)){
//                    studEnrol = se;
//            }
//        }
//
//        Assertions.assertEquals(true, enrollmana.getStudentEnrolmentList().contains(studEnrol));

        //Failed test case

        studID = "s101312";
        couID = "BUS2232";
        sem = "2020C";
        s = null;
        c = null;
        studEnrol = null;
        for (Student student : enrollmana.getStudentList()) {
            if (studID.equalsIgnoreCase(student.getStudentID())) {
                s = student;
                //System.out.println(s.getStudentName());
            }
        }
        for (Course course : enrollmana.getCourseList()) {
            if (couID.equalsIgnoreCase(course.getCourseID())) {
                c = course;
                //System.out.println(s.getStudentName());
            }
        }

        enrollmana.add(s, c, sem);

        for(StudentEnrolment se: enrollmana.getStudentEnrolmentList()){
            if(se.getStudent().getStudentID().equalsIgnoreCase(s.getStudentID()) &&
                    se.getCourse().getCourseID().equalsIgnoreCase(c.getCourseID()) &&
                    se.getSemester().equalsIgnoreCase(sem)){
                studEnrol = se;
            }
        }

        Assertions.assertEquals(false, !enrollmana.getStudentEnrolmentList().contains(studEnrol));
    }
}
