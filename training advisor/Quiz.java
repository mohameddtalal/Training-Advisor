import java.util.ArrayList;
import java.util.List;

public class Quiz extends  HelpDesk{
    private double score;
    private String name;
    public int noOfQ;
    public List<HelpDesk> questions = new ArrayList<>(noOfQ);
    public Quiz(List<HelpDesk> questions, int noOfQ) {

        this.questions = questions;
        this.noOfQ=noOfQ;
    }
    public  List<HelpDesk> getQuestions()
    {
        return questions;
    }

    public String getName() { return name;}

    public void setName(String name) { this.name = name; }
    public void setScore(double score) { this.score = score; }
    public double getScore() {
        return score;
    }
}