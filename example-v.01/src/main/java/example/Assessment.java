package example;

import java.util.ArrayList;

public class Assessment {
    
    public String title;
    public String id;
    public ArrayList<Question> questions;
    
    public Assessment(String title, String id) {
        this.title = title;
        this.id = id;
        this.questions = new ArrayList<Question>();
    }
    
    public void addQuestion(Question question) {
        this.questions.add(question);
    }
    
}
