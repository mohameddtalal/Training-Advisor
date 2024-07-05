import java.util.ArrayList;
import java.util.List;
public class User {
    private String name;
    private String email;
    private String password;
    private String phone;
    private List<Quiz> completedQuizzes = new ArrayList<>();
    private boolean activated;
    private List<Course> completedCourses = new ArrayList<>();
    private ArrayList<Course> enrolledCourses = new ArrayList<>();

    public User(String name, String email, String password,String phone) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.activated = false;
    }
    public User(){

    }
    public void setName(String n)
    {
        name = n;
    }
    public void setPhone(String p)
    {
        phone = p;
    }
    public void setEmail(String e)
    {
        email = e;
    }
    public void setPassword(String pass)
    {
        password = pass;
    }
    public String getName() { return name; }
    public boolean authenticate(String email, String password) {
        return this.email.equals(email) && this.password.equals(password) && this.activated;
    }
    public void activate() {
        this.activated = true;
    }

    public void veiwProfile() {
        System.out.println("Name: " + name + ", Email: " + email + ", Phone: " + phone) ;
    }

    public List<Course> searchCourses(String keyword,List<Course> courses) {
        List<Course> matchingCourses = new ArrayList<>();
        for (Course course : courses) {
            if (course.matches(keyword)) {
                matchingCourses.add(course);
            }
        }

        return matchingCourses;
    }
    public ArrayList<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public List<Course> getCompletedCourses() {
        return completedCourses;
    }
    public List<Quiz> getCompletedQuizzes() {
        return completedQuizzes;
    }
    public String getProgressReport(Course course) {
        return course.getProgressReport(this);
    }
}