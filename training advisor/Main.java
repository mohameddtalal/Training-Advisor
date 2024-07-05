import java.util.Scanner;

public class Main {
    private static UserMenu userMenu = new UserMenu();
    private static AdminMenu adminMenu = new AdminMenu();
    private static Login login = new Login();
    private static  Register register = new Register();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while(!exit) {
            System.out.println("Welcome to Training Advisor");
            System.out.println("1. Register\n2. Login\n3. admin menu \n4. exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    register.MainMenu(scanner, userMenu.getUsers());
                    break;
                case 2:
                    login.MainMenu(scanner, userMenu.getUsers());
                    break;
                case 3:
                    User user = new User();
                    adminMenu.Menu(scanner,user);
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}