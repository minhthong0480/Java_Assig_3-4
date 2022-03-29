import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Enrolmanager implements StudentEnrolmentManager {
    public ArrayList<String> studentList = new ArrayList<>();
    public ArrayList<Course> courseList = new ArrayList<>();
    public ArrayList<StudentEnrolment> studentEnrolmentList = new ArrayList<>();


    String path ="/Users/thongnguyen/Documents/GitHub/Java_Assig_3-4/default.csv";

    public void importFile(String fileName) throws FileNotFoundException {
        Scanner scanner;
        try{
            scanner = new Scanner(new File(path));
        }
        catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println("File not found");
            scanner = new Scanner(new File(path));
        }
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            String [] values = line.split(",");
            int noCredits = Integer.parseInt(values[5]);
            Student s = new Student(values[0], values[1], values[2]);
            Course c = new Course(values[3], values[4], noCredits);
            StudentEnrolment enrolment = new StudentEnrolment(s, c, values[6]);
        }
    }
//    {
//        try {
//            Scanner scanner = new Scanner(new FileReader(path));
//
//            while(scanner.hasNextLine()){
//                String InputLine = scanner.nextLine();
//                String [] values = line.split(",");
//                int noCredits = Integer.parseInt(splitInfo[5]);
//                Student s = new Student(splitInfo[0], splitInfo[1], splitInfo[2]);
//                Course c = new Course(splitInfo[3], splitInfo[4], noCredits);
//                StudentEnrolment enrolment = new StudentEnrolment(s, c, splitInfo[6]);
//
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

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
