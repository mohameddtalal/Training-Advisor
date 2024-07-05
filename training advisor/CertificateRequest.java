import java.util.Random;
public class CertificateRequest extends TimeStamp{
    private Course course;
    private User user;

    public Course getCourse() {
        return course;
    }

    public User getUser() {
        return user;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CertificateRequest(Course course, User user) {
        this.course = course;
        //this.completionDate = completionDate;
        this.user = user;
    }
    public String generateRandomId(int size) {
        String id = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder string = new StringBuilder(size);

        for (int i = 0; i < size; i++) {
            int randomI = random.nextInt(id.length());
            char randomC = id.charAt(randomI);
            string.append(randomC);
        }

        return string.toString();
    }
    public void issueCertificate(){
        displayTime();
    }
}