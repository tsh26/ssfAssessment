package vttp.ssf.assessment.eventmanagement.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import jakarta.validation.Valid;
import vttp.ssf.assessment.eventmanagement.models.FormData;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;

@Controller
@RequestMapping("/events")
public class RegistrationController {

    @Autowired
    RedisRepository redisRepo;

    // TODO: Task 6
    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("formData", new FormData());

        return "eventregister";
    }
    
// TODO: Task 7
    @PostMapping("/submit-form")
    public String processRegistration(@Valid FormData formData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "eventregister"; // Return back to form page but with error messages
        }
        // else if
        // Process the form data (save to Redis) if server side validation passes.
        // Applicants must be >= 21 years old
        // noOfTickets <= participants count & eventSize

        return "SuccessRegistration"; // Redirect to a success page

        // else 
        // server side validation fails
        // return "ErrorRegistration";
    }
}