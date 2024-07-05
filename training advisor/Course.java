import java.util.ArrayList;
import java.util.List;
public class Course {
    private String name;
    private double rating;
    private List<String> reviews;
    private List<Course> prerequisites;
    private List<String> materials = new ArrayList<>();
    private double price;
    private List<Quiz> quizzes ;

    private String certificateID;

    public boolean completed;
    public List<User> enrolledUsers;

    public Course() {
        this.name = "";
        this.prerequisites = new ArrayList<>();
        this.materials = null;
        this.quizzes = null;
        this.reviews = null;
        this.rating = 0.0;
        this.price =0;
        this.enrolledUsers = new ArrayList<>();
        completed=false;
    }
    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
    public void setQuizzes(List<Quiz> quizzes) {
        this.quizzes = quizzes;
    }
    public String getCertificateID() {
        return certificateID;
    }

    public void setCertificateTitle(String certificateID) {
        this.certificateID = certificateID;
    }

    public String getName() {
        return name;
    }
    public void setName(String n) { name = n; }

    public void setPrice(double p) { price=p; }
    public double getRating() { return rating; }
    public List<String> getReviews() { return reviews; }

    public List<Course> getPrerequisites() { return prerequisites; }
    public  List<String> getMaterials() { return materials; }
    public List<Quiz> getQuizzes() { return quizzes; }
    public void setMaterials(List<String> materials) { this.materials = materials; }
    public void setPrerequisites(List<Course> Prerequisites) { this.prerequisites = Prerequisites; }
    public boolean matches(String keyword) {
        return name.contains(keyword) || name.contains(keyword) || name.contains(keyword)  ;
    }

    public void removeUser(User user) {
        enrolledUsers.remove(user);
    }

    public List<User> getEnrolledUsers() {
        return enrolledUsers;
    }
    public String getProgressReport(User user) {
        if (enrolledUsers.contains(user)) {
            String report = "Progress report for " + user.getName() + " in " + getName() + ":\n";
            int i=1;
            for (Quiz quiz : getQuizzes()) {
                report += "Quiz no. "+ i++ + ", Score: " + quiz.getScore() + "\n";

            }
            return report;
        }
        else {
            return "User is not enrolled in this course.";
        }
    }
}