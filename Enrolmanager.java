import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Enrolmanager implements StudentEnrolmentManager {
    public ArrayList<Student> studentList = new ArrayList<>();
    public ArrayList<Course> courseList = new ArrayList<>();
    public ArrayList<StudentEnrolment> studentEnrolmentList = new ArrayList<>();


    String path ="/Users/thongnguyen/Documents/GitHub/Java_Assig_3-4/default.csv";
    String line = "";
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));

            while((line = br.readLine()) != null){
                String [] values = line.split(",");
                studentList.add(new Student(values[0],values[1],values[2]));
                System.out.println(studentList);
                break;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
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
