package example;

import java.util.ArrayList;

public class Checkbox extends Question {
 
    private ArrayList<String> user_answers = new ArrayList<String>();

    public Checkbox(String text, String[] options, String[] answers) {
        this.text = text;
        this.options = options;
        this.answers = answers;
    }

    public String[] getAnswers() {
        return this.answers;
    }

    // To avoid overfilling the list
    public void clearUserAnswer() {
        this.user_answers.clear();
    }

    public void addUserAnswer(String answer) {
        this.user_answers.add(answer); 
    }

    public ArrayList<String> getUserAnswers() {
        return this.user_answers;
    }
  
}