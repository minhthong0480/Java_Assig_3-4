class Student{

    private String StudentID;
    private String StudentName;
    private String BirthDate;

    public Student() {

    }

    public String getStudentID() {
        return StudentID;
    }

    public String getStudentName() {
        return StudentName;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public void setStudentName(String studentName) {
        StudentName = studentName;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public Student(String StudentID, String StudentName, String BirthDate) {
        this.StudentID = StudentID;
        this.StudentName = StudentName;
        this.BirthDate = BirthDate;
    }

    @Override
    public String toString(){
        return StudentID +" "+ StudentName +" "+ BirthDate;
    }
}