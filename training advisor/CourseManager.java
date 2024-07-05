public class CourseManager extends Course {
    public CourseManager(){
        super();
    }

    public void displayMaterials(Course course1) {
        System.out.println("Materials for " + course1.getName() + ":");
        for (int j = 0; j < course1.getMaterials().size(); j++) {
            System.out.println((j + 1) + ") " + course1.getMaterials().get(j));
        }
    }

    public void displayPrerequisites(Course course1) {
        System.out.println("Prerequisites for " + course1.getName() + ":");
        for (int j = 0; j < course1.getPrerequisites().size(); j++) {
            System.out.println((j + 1) + ") " + course1.getPrerequisites().get(j).getName());
        }
    }

    public void addMaterial(String material) {
        getMaterials().add(material);
    }
    public void removeMaterial(String material,Course course1)
    {
        course1.getMaterials().remove(material);
    }

    public void addPrerequisite(Course prerequisite, Course course) {
        course.getPrerequisites().add(prerequisite);
    }

    public void addMaterial(String material,Course course) {
        course.getMaterials().add(material);
    }

    public void addQuiz(Quiz quiz,Course course) {
        course.getQuizzes().add(quiz);
    }

    public void enrollUser(User user) {
        enrolledUsers.add(user);
    }

    public void markCompleted() {
        completed = true;
    }

    public boolean hasUserEnrolled(User user) {
        return enrolledUsers.contains(user);
    }
}
