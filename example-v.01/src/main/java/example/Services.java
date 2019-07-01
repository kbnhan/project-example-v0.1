package example;

import org.springframework.stereotype.Service;
// File reading imports
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
// Gson imports
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;

@Service 
public class Services {

    public static Assessment jsonToAssessObj(String path) throws FileNotFoundException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(bufferedReader).getAsJsonArray();

        String question_title = gson.fromJson(array.get(0), String.class);
        String question_id = gson.fromJson(array.get(1), String.class);
        Assessment assessment = new Assessment(question_title, question_id);

        for (int i = 2; i < array.size(); i++) {
            Question question = gson.fromJson(array.get(i), Question.class);
            assessment.addQuestion(question);
        }

        return assessment;

    }

    // Method to create MultiChoice type questions. 
    public static MultiChoice createMulti(String path, int index) {

        try {
            Assessment assessment = jsonToAssessObj(path);
            MultiChoice question = new MultiChoice(
                assessment.questions.get(index).text, 
                assessment.questions.get(index).options,
                assessment.questions.get(index).answers
                );
            return question; 
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return null;
    }

    // Method to create Checkbox type questions. 
    public static Checkbox createCheckbox(String path, int index) {

        try {
            Assessment assessment = jsonToAssessObj(path);
            Checkbox question = new Checkbox(
                assessment.questions.get(index).text, 
                assessment.questions.get(index).options, 
                assessment.questions.get(index).answers
                );
            return question;
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return null;

    }

    // Method to create TextInput type questions. 
    public static TextInput createTextInput(String path, int index) {

        try {
            Assessment assessment = jsonToAssessObj(path);
            TextInput question = new TextInput(
                assessment.questions.get(index).text,
                assessment.questions.get(index).answers
                );
            return question;
        } catch (FileNotFoundException e) {
            System.err.println(e);
        }
        return null; 

    }

}