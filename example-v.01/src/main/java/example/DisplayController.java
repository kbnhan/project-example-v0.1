package example;

// Imports for Spring MVC
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DisplayController {

    String path = "/Users/kevinnhan/Desktop/project-example-v0.1/example-v.01/src/main/java/example/assessment1.json";
    Assessment assessment = Services.jsonToAssessObj(path);

    MultiChoice question1 = new MultiChoice(
        assessment.questions.get(0).text, 
        assessment.questions.get(0).options,
        assessment.questions.get(0).answers
        );

    Checkbox question2 = new Checkbox(
        assessment.questions.get(1).text, 
        assessment.questions.get(1).options, 
        assessment.questions.get(1).answers
        );

    // URL mapping functions
    @GetMapping("/assessment1")
    public String displayQuestion (Model model) {
        model.addAttribute("question1", question1);
        model.addAttribute("question2", question2);
        return "combined";
    }

    @RequestMapping("/result")
    public String getAnswerParam () {
        
        return "result";
        
    }


}