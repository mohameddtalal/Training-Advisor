import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminMenu implements Menu{

    @Override
    public List<User> getUsers() {return users;}


    public void Menu(Scanner scanner, User user) {
        boolean exit = false;
        while(exit==false) {
            System.out.println("//Note for the T.A: the username is 'Admin', and the password is '123' ");
            System.out.println("Enter username:");
            String setUsername = scanner.nextLine();
            System.out.println("Enter password:");
            String password = scanner.nextLine();
            if (!admin.authenticate(setUsername, password)) {
                System.out.println("Wrong password or username");
                break;
            }
            boolean exitAdmin = false;
            while (exitAdmin == false) {
                System.out.println("Welcome Admin");
                System.out.println("1. Add course\n2. Remove course\n3. Add course materials\n4. Add course prerequisites\n5. Add quiz\n6. Remove course material\n7. Remove course Prerequisites\n8. Remove quiz\n9. Logout");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Enter course name:");
                        String courseNameToBeAdded = scanner.nextLine();
                        System.out.println("Enter course price:");
                        int coursePrice = scanner.nextInt();
                        Course course = new Course();
                        course.setName(courseNameToBeAdded);
                        course.setName(courseNameToBeAdded);
                        course.setPrice(coursePrice);
                        adminManager.addCourse(courses,course);
                        break;
                    case 2:
                        System.out.println("Enter course name:");
                        String courseName = scanner.nextLine();
                        boolean flag = false;

                        for (int i = 0; i < courses.size(); ++i) {
                            if (courses.get(i).getName().equals(courseName)){
                                adminManager.removeCourse(courses,courses.get(i),admin);
                                flag = true;
                                break;
                            }
                        }
                        if (flag == false) {
                            System.out.println("Course not found.");

                            exit= true;
                        }
                        break;
                    case 3:
                        boolean checker = false;
                        System.out.println("Enter course name:");
                        String courseName2 = scanner.nextLine();
                        List<String> stringList = new ArrayList<>();
                        System.out.println("Enter strings (one per line). Enter an empty line to stop.");
                        String material = scanner.nextLine();
                        while (!material.isEmpty()) {
                            stringList.add(material);
                            material = scanner.nextLine();
                        }

                        for (int i = 0; i < courses.size();i++) {
                            if (courses.get(i).getName().equals(courseName2)) {
                                checker = true;
                                adminManager.setMaterials(courses.get(i), stringList,admin);
                                break;
                            }
                        }
                        if (checker == false) {
                            System.out.println("Course not found.");
                        }

                        break;
                    case 4:
                        boolean checkerPre = false;
                        boolean flagTest = false;
                        System.out.println("Enter course name:");
                        String courseName4 = scanner.nextLine();
                        for(Course courseTest: courses){
                            if (courseTest.getName().equals(courseName4)) {
                                flagTest = true;
                                System.out.println("Enter number of prerequisites:- ");
                                int noOfP = scanner.nextInt();
                                scanner.nextLine();
                                for(int i=0;i<noOfP;i++) {
                                    System.out.println("Enter course prerequisite no."+ (i+1) + " :- ");
                                    String prerequisites = scanner.nextLine();
                                    for(Course course1 : courses ){
                                        if (course1.getName().equals(prerequisites)) {
                                            checkerPre= true;
                                            adminManager.addPre(course1, courseTest);
                                            break;
                                        }
                                    }
                                }
                            }
                        }

                        if(flagTest == false) {
                            System.out.println("No course name was found");
                        }
                        if(checkerPre == false) {
                            System.out.println("No prerequisite name was found");
                        }
                        break;
                    case 5:
                        boolean checker3 = false;
                        System.out.println("Enter course name:");
                        String courseName5 = scanner.nextLine();

                        for (Course COUSRE : courses) {
                            if (COUSRE.getName().equals(courseName5)) {
                                checker3 = true;
                                adminManager.addQuiz(COUSRE);
                                break;
                            }
                        }
                        if (checker3 == false) {
                            System.out.println("Invalid course name");
                            break;
                        }
                        System.out.println("Done.");
                        break;
                    case 6:
                        boolean checkerTestOfMaterial = false;
                        boolean checkerTestOfCourse = false;
                        System.out.println("Enter course name:- ");
                        String courseName6 = scanner.nextLine();
                        System.out.println("Enter material to be removed:- ");
                        String materialRemove = scanner.nextLine();

                        for (int i = 0; i < courses.size();i++) {
                            if (courses.get(i).getName().equals(courseName6)) {
                                checkerTestOfCourse = true;
                                for(int j=0;j<courses.get(i).getMaterials().size();j++) {
                                    if(courses.get(i).getMaterials().get(j).equals(materialRemove)){
                                        checkerTestOfMaterial= true;
                                        adminManager.removeMaterial(courses.get(i), materialRemove, courseManager);
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        if (checkerTestOfCourse == false) {
                            System.out.println("Course not found.");
                        }
                        if (checkerTestOfMaterial == false) {
                            System.out.println("Material1 not found.");
                        }

                        break;
                    case 7:
                        boolean check7 = false;
                        boolean check72 = false;
                        System.out.println("Enter course name:");
                        String courseName7 = scanner.nextLine();
                        for(Course courseTest: courses){
                            if (courseTest.getName().equals(courseName7)) {
                                check7 = true;
                                System.out.println("Enter course prerequisite name to be removed. ");
                                String prerequisiteRemove = scanner.nextLine();
                                for(int i=0;i<courseTest.getPrerequisites().size();i++ ){
                                    if(courseTest.getPrerequisites().get(i).getName().equals(prerequisiteRemove)){
                                        check72=true;
                                        adminManager.removePre(courseTest.getPrerequisites().get(i),courseTest);
                                        break;
                                    }
                                }
                                break;
                            }
                        }

                        if(check7 == false) {
                            System.out.println("No course name was found");
                        }
                        if(check72 == false) {
                            System.out.println("No prerequisite name was found");
                        }
                        break;
                    case 8:
                        boolean checker8 = false;
                        System.out.println("Enter course name:");
                        String courseName8 = scanner.nextLine();
                        for(Course course8 : courses){
                            if(course8.getName().equals(courseName8)){
                                adminManager.removeQuiz(course8);
                                checker8 = true;
                            }
                        }
                        if(!checker8){
                            System.out.println("Wrong course name.");
                        }
                        break;
                    case 9:
                        System.out.println("logout successfully");
                        exitAdmin = true;
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                        break;
                }
            }
        }
    }

}
