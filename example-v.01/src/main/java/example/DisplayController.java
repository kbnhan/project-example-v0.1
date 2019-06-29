package example;

// Imports for Spring MVC
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DisplayController {

    Assessment assessment;

    public DisplayController(Assessment assessment) {
        this.assessment = new Assessment(assessment.title, assessment.id);
    }

    @GetMapping("/assessment1")
    public String displayQuestion (Model model) {

        return "combined";
    }

    @RequestMapping("/result")
    public String getAnswerParam () {
        
        return "result";
        
    }


}