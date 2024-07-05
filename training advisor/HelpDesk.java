//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class HelpDesk {
    public String answer;
    public String text;

    HelpDesk() {
    }
    HelpDesk(String answer, String text) {
    this.text = text;
    this.answer = answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    public String getAnswer() {
        return this.answer;
    }
}
