import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager extends User {
    public void enroll(String keyword, List<Course> courses,User user) {
        boolean FinalFlag = false;
        List<Course> matchingCourses = searchCourses(keyword, courses);

        if (matchingCourses.isEmpty()) {
            System.out.println("No matching courses found.");
        } else {
            System.out.println("Matching courses:");
            for (int i = 0; i < matchingCourses.size(); i++) {
                System.out.println((i + 1) + ") " + matchingCourses.get(i).getName());
            }
            System.out.print("Enter the number of the course you want to enroll in: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice > 0 && choice <= matchingCourses.size()) {
                if(!matchingCourses.get(choice - 1).getPrerequisites().isEmpty()){
                    for(int itr=0;itr<matchingCourses.get(choice-1).getPrerequisites().size();itr++) {
                        if (matchingCourses.get(choice - 1).getPrerequisites().get(itr).completed == true) {
                            FinalFlag = true;
                            user.getEnrolledCourses().add(matchingCourses.get(choice - 1));
                            System.out.println(user.getName() + " is enrolled successfully in " + matchingCourses.get(choice - 1).getName());
                            for (int j = 0; j < courses.size(); j++) {
                                if (courses.get(j).getName().equals(matchingCourses.get(choice - 1).getName())) {
                                    courses.get(j).enrolledUsers.add(this);
                                }
                            }
                        }
                    }
                }
                else{
                    FinalFlag = true;
                    user.getEnrolledCourses().add(matchingCourses.get(choice - 1));
                    System.out.println(user.getName() + " is enrolled successfully in " + matchingCourses.get(choice - 1).getName());
                    for (int j = 0; j < courses.size(); j++) {
                        if (courses.get(j).getName().equals(matchingCourses.get(choice - 1).getName())) {
                            courses.get(j).enrolledUsers.add(this);
                        }
                    }
                }

                if(FinalFlag==false){
                    System.out.println("You haven't completed the prerequisite course.");
                }

            }
            else {
                System.out.println("Invalid choice.");
            }
        }
    }
    public void withdrawCourse(Course course,User user) {
        user.getEnrolledCourses().remove(course);
        for(int i=0;i<1;i++) {
            System.out.println(course.getName() + " was removed from your courses.");
        }
        course.removeUser(user);
    }

    public void takeQuiz(Course course, Quiz quiz, User user) {
        Scanner scanner = new Scanner(System.in);
        List<HelpDesk> quizQuestions = new ArrayList<>();
        int numCorrectAnswers = 0;
        for(int i=0;i<course.getQuizzes().size();i++) {
            if(course.getQuizzes().get(i).getName().equals(quiz.getName())) {
                quizQuestions = course.getQuizzes().get(i).getQuestions();
            }
        }

        for (HelpDesk question : quizQuestions) {
            System.out.println(question.getText());
            System.out.print("Enter your answer: ");
            String  userAnswer = scanner.nextLine();
            if (question.getAnswer().equals(userAnswer)) {
                numCorrectAnswers++;
            }
        }
        double score = ((double) numCorrectAnswers / quizQuestions.size()) * 100;
        quiz.setScore(score);
        user.getCompletedQuizzes().add(quiz);
        System.out.println("Quiz completed. Score: " + score + "%");
        if(score >= 50) {
            course.completed = true;
            user.getCompletedCourses().add(course);
        }
    }
    public void requestCertificate(Course course, User user) {
        CertificateRequest certificateRequest = new CertificateRequest(course, user);
        if (course.isCompleted()) {
            System.out.print("Certificate for " + course.getName() + " is issued on: ");
            certificateRequest.issueCertificate();
            String str1 = certificateRequest.generateRandomId(10);
            course.setCertificateTitle(str1);
            System.out.println("Certificate ID: " + course.getCertificateID());


        } else {
            System.out.println("You have not completed this course yet.");
        }
    }
}
