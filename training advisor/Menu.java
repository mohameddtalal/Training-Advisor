import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public interface Menu {
     static Admin admin = new Admin();
     static AdminManager adminManager = new AdminManager();
     static List<User> users = new ArrayList();
     static UserManager userManager = new UserManager();
     static CourseManager courseManager = new CourseManager();
     static List<Course> courses= new ArrayList<>();

    public List<User> getUsers();

    public void Menu(Scanner scanner, User user);


}