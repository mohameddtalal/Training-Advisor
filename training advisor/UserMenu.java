import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserMenu implements Menu {

    @Override
    public List<User> getUsers() {return users;}
    public void Menu(Scanner scanner, User user) {
        boolean exiting = false;

        while(exiting==false) {
            System.out.println("Welcome " + user.getName());
            System.out.println("1. View Profile\n2. Edit Profile\n3. Search Courses\n4. My courses\n5. My progress\n6. Logout");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    user.veiwProfile();
                    break;
                case 2:

                    boolean toGetout = false;
                    while(toGetout == false) {
                        System.out.println("What do you want to edit:");
                        System.out.println("1. Name\n2. Email \n3. Phone\n4. Password\n5. Exit");
                        int answer = scanner.nextInt();
                        scanner.nextLine();
                        switch (answer) {
                            case 1:
                                System.out.println("Enter name:");
                                String name = scanner.nextLine();
                                user.setName(name);
                                break;
                            case 2:
                                System.out.println("Enter Email:");
                                String email = scanner.nextLine();
                                user.setEmail(email);
                                break;
                            case 3:
                                System.out.println("Enter Phone:");
                                String phone = scanner.nextLine();
                                user.setPhone(phone);
                                break;
                            case 4:
                                System.out.println("Enter Password:");
                                String Password = scanner.nextLine();
                                user.setPassword(Password);
                                break;
                            case 5:
                                System.out.println("Exiting");
                                toGetout = true;
                                break;
                            default:
                                System.out.println("Invalid answer");
                                break;
                        }
                    }
                    System.out.println("Profile updated successfully.");
                    break;
                case 3:
                    System.out.print("Enter a search keyword: ");
                    String keyword = scanner.nextLine();
                    userManager.enroll(keyword,courses,user);
                    break;
                case 4:
                    System.out.println("Enrolled courses: ");
                    for(int i =0;i<user.getEnrolledCourses().size();i++) {
                        System.out.println(i+1 + ": " + user.getEnrolledCourses().get(i).getName());
                    }
                    System.out.print("Select a course number: ");
                    int noOfCourse = scanner.nextInt();
                    if (noOfCourse >= 1 && noOfCourse <= user.getEnrolledCourses().size()) {
                        Course selectedCourse = user.getEnrolledCourses().get(noOfCourse - 1);

                        System.out.println("1. Take quiz \n2. view course material\n3. view course prerequisites\n4. Withdraw\n5. Request a certificate\n6. Exit\n");
                        int CHOICE = scanner.nextInt();
                        boolean exit = false;
                        while(exit==false) {
                            switch (CHOICE) {
                                case 1:
                                    if(selectedCourse.getQuizzes().isEmpty()){
                                        System.out.println("No quizzes available");
                                        break;
                                    }
                                    System.out.println("What quiz do you want to take: ");
                                    for(int i=0;i<selectedCourse.getQuizzes().size();i++) {
                                        System.out.println(i+1 + ") " + selectedCourse.getQuizzes().get(i).getName());
                                    }
                                    int answer = scanner.nextInt();
                                    if(answer >0 && answer<=selectedCourse.getQuizzes().size()){
                                        Quiz selectedQuiz = selectedCourse.getQuizzes().get(answer-1);
                                        userManager.takeQuiz(selectedCourse,selectedQuiz,user);
                                    }
                                    else
                                        System.out.println("Invalid choice");
                                    exit = true;
                                    break;
                                case 2:
                                    courseManager.displayMaterials(selectedCourse);
                                    exit = true;
                                    break;
                                case 3:
                                    courseManager.displayPrerequisites(selectedCourse);
                                    exit = true;
                                    break;
                                case 4:
                                    userManager.withdrawCourse(selectedCourse,user);
                                    exit = true;
                                    break;
                                case 5:
                                    userManager.requestCertificate(selectedCourse, user);
                                    exit = true;
                                    break;
                                case 6:
                                    System.out.println("Exiting..");
                                    exit = true;
                                    break;
                                default:
                                    System.out.println("Error, Invalid choice");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 5:
                    System.out.println("Choose a registered course from the following to see your progress: ");
                    for(int i =0; i<user.getEnrolledCourses().size();i++)
                    {
                        System.out.println(i+1 + ": "+  user.getEnrolledCourses().get(i).getName());
                    }
                    int urChoice = scanner.nextInt();
                    if(urChoice > 0 && urChoice <= user.getEnrolledCourses().size() )
                    {
                        Course selectedCourse = user.getEnrolledCourses().get(urChoice - 1);
                        System.out.println(user.getProgressReport(selectedCourse));
                    }
                    break;
                case 6:
                    exiting = true;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }

    }
}
