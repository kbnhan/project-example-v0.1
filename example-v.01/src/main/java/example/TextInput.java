package example; 

public class TextInput extends Question { 

    private String user_answer;

    public TextInput(String text, String[] answers) {
        this.text = text;
        this.answers = answers;
    }

    public String getAnswer() {
        return this.answers[0];
    }

    public void setUserAnswer(String user_answer) {
        this.user_answer = user_answer;
    }

    public String getUserAnswer() {
        return this.user_answer;
    }

}