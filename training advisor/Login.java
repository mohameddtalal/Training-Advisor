import java.util.Iterator;
import java.util.Scanner;
import java.util.List;
public class Login implements  MainMenu{
    private UserMenu userMenu = new UserMenu();
    public void MainMenu(Scanner scanner, List<User> users) {
        System.out.println("Enter email:");
        String email = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        User user = null;
        Iterator var4 = users.iterator();

        while(var4.hasNext()) {
            User u = (User)var4.next();
            if (u.authenticate(email, password)) {
                user = u;
                break;
            }
        }

        if (user == null) {
            System.out.println("Invalid email or password.");
        } else {
            userMenu.Menu(scanner, user);
        }

    }
}
