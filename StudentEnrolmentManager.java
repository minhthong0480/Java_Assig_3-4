public interface StudentEnrolmentManager {
    public void add(Student s, Course c, String sem);
    public void update(Student s, Course c, String sem, String opt);
    public void delete(Student s, Course c, String sem);
    public void getOne(Student s, Course c, String sem);
    public void getAll();

}
