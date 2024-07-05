import java.util.Scanner;
import java.util.List;
public class Register implements MainMenu{
    public void MainMenu(Scanner scanner, List<User> users) {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        System.out.println("Enter phone:");
        String phone = scanner.nextLine();
        User user = new User(name, email, password,phone);
        users.add(user);
        user.activate();
        System.out.println("Registration successful. Please login.");
    }
}
