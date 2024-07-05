import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminManager extends Admin{
    public AdminManager() {
        super();
    }

    public void addCourse(List<Course> courses, Course course) {
        courses.add(course);
        System.out.println("Course " + course.getName() + " has been added successfully.");
    }
    public void addPre(Course courseToBeAdded, Course course) {
        course.getPrerequisites().add(courseToBeAdded) ;
        System.out.println("Prerequisites are added successfully.");
    }

    public void removePre(Course courseToBeRemoved, Course course) {
        course.getPrerequisites().remove(courseToBeRemoved) ;
        System.out.println("Prerequisites are removed successfully.");

    }
    public void removeCourse(List<Course> courses,Course course,Admin admin) {
        if (courses.contains(course)) {
            courses.remove(course);
            System.out.println("Course " + course.getName() + " has been removed.");
        } else {
            System.out.println("Course " + course.getName() + " was not found.");
        }
    }
    public void addQuiz(Course course) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of quiz");
        String name = scanner.nextLine();
        System.out.println("Enter number of questions");
        int noOfQ = scanner.nextInt();
        List<HelpDesk> questions = new ArrayList<>(noOfQ);

        scanner.nextLine();
        for (int i =0;i< noOfQ;i++){
            System.out.print("Enter question number " + (i+1) + ": ");
            String text = scanner.nextLine();
            System.out.print("Enter the answer of the question number " + (i+1) + ": ");
            String answer = scanner.nextLine();
            HelpDesk question = new HelpDesk(answer,text);
            questions.add(question);
        }
        Quiz quiz = new Quiz(questions,noOfQ);
        quiz.setName(name);
        quizzes.add(quiz);
        course.setQuizzes(quizzes);

    }

    public void removeQuiz(Course course) {
        boolean flag = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name of quiz");
        String name = scanner.nextLine();
        for (int i =0;i< course.getQuizzes().size();i++){
            if(course.getQuizzes().get(i).getName().equals(name)){
                flag = true;
                course.getQuizzes().remove(course.getQuizzes().get(i));
            }
        }
        if(flag== false){
            System.out.println("wrong quiz name");
        }
        else
            System.out.println("Quiz removed");

    }

    public void setMaterials(Course course, List<String> materials,Admin admin) {
        course.setMaterials(materials);
        System.out.println("Materials set successfully.");
    }
    public void removeMaterial(Course course, String material, CourseManager courseManager) {
        courseManager.removeMaterial(material,course);
        System.out.println("Material removed successfully.");
    }
}
