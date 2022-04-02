class Course{
    private String CourseID;
    private String CourseName;
    private int NumberofCredit;

    public Course() {

    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String courseID) {
        CourseID = courseID;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public int getNumberofCredit() {
        return NumberofCredit;
    }

    public void setNumberofCredit(int numberofCredit) {
        NumberofCredit = numberofCredit;
    }

    public Course(String CourseID, String CourseName, int NumberofCredit){
        this.CourseID = CourseID;
        this.CourseName = CourseName;
        this.NumberofCredit = NumberofCredit;
    }

    @Override
    public String toString(){
        return CourseID +" "+ CourseName +" "+ NumberofCredit;
    }
}