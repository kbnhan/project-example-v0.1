package example;

// File reading imports
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
// Gson imports
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.JsonArray;

public class Services {

    public Assessment jsonToAssessObj(String path) throws FileNotFoundException {

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


}