package example;

import java.io.FileNotFoundException;
import javax.annotation.PostConstruct;
// Imports for Spring MVC
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DisplayController {

    // String path = "/Users/kevinnhan/Desktop/project-example-v0.1/example-v.01/src/main/java/example/assessment1.json";
    String path = "/Users/knhan/Desktop/project-example-v0.1/example-v.01/src/main/java/example/assessment1.json"; // NASA path
    MultiChoice question1 = Services.createMulti(path);
    Checkbox question2 = Services.createCheckbox(path);
    TextInput question3 = Services.createTextInput(path);

    @GetMapping("/assessment1")
    public String displayQuestion (Model model) {
        model.addAttribute("question1", question1);
        model.addAttribute("question2", question2);
        model.addAttribute("question3", question3);
        return "assessment1";
    }

    @PostMapping("/assessment1")
    public String formSubmit(@ModelAttribute TextInput question, Model model) {
        model.addAttribute("question1", question1);
        model.addAttribute("question2", question2);
        model.addAttribute("question3", question3); // Refers to question3 object, defined in class attributes
        model.addAttribute("question", question); // Refers to question object, defined from method parameters
        return "result";
    }

    @RequestMapping("/result")
    public String getAnswerParam (
        @RequestParam(name="group1", required=false) String color, 
        @RequestParam(name="box1", required=false) String animal1,
        @RequestParam(name="box2", required=false) String animal2,
        @RequestParam(name="box3", required=false) String animal3, 
        Model model 
        ) {
        
        model.addAttribute("question1", question1);
        model.addAttribute("question2", question2);
        model.addAttribute("question3", question3); // Both reference the same object
        model.addAttribute("question", question3); // Both reference the same object. Might change later...
        question1.setUserAnswer(color);
        question2.clearUserAnswer();
        question2.addUserAnswer(animal1);
        question2.addUserAnswer(animal2);
        question2.addUserAnswer(animal3);
        return "result";
        
    }

}