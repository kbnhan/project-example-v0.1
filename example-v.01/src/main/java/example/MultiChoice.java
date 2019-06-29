package example;

public class MultiChoice extends Question{

    private String answer;
    private String user_answer;

    public MultiChoice(String text, String[] options, String answer) {
        super(text, options);
        this.answer = answer;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setUserAnswer(String input) {
        this.user_answer = input;
    }

    public String getUserAnswer() {
        return this.user_answer;
    }
    
}