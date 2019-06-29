package example;

import java.io.FileNotFoundException;

import javax.annotation.PostConstruct;
// Imports for Spring MVC
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DisplayController {

    String path = "/Users/kevinnhan/Desktop/project-example-v0.1/example-v.01/src/main/java/example/assessment1.json";
    MultiChoice question1 = Services.createMulti(path);
    Checkbox question2 = Services.createCheckbox(path);

    // URL mapping functions
    @GetMapping("/assessment1")
    public String displayQuestion (Model model) {
        model.addAttribute("question1", question1);
        model.addAttribute("question2", question2);
        return "combined";
    }

    @RequestMapping("/result")
    public String getAnswerParam (
        @RequestParam(name="group1", required=false) String answer1, 
        @RequestParam(name="box1", required=false) String animal1,
        @RequestParam(name="box2", required=false) String animal2,
        @RequestParam(name="box3", required=false) String animal3, 
        Model model 
        ) {
        
        model.addAttribute("question1", question1);
        model.addAttribute("question2", question2);
        question1.setUserAnswer(answer1);
        question2.clearUserAnswer();
        question2.addUserAnswer(animal1);
        question2.addUserAnswer(animal2);
        question2.addUserAnswer(animal3);
        return "result";
        
    }


}