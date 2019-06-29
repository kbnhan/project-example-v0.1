package example;

public class MultiChoice extends Question { 

    private String user_answer;

    public MultiChoice(String text, String[] options, String[] answers) {
        this.text = text;
        this.options = options;
        this.answers = answers;
    }

    public String getAnswer() {
        return this.answers[0];
    }

    public void setUserAnswer(String input) {
        this.user_answer = input;
    }

    public String getUserAnswer() {
        return this.user_answer;
    }
    
}