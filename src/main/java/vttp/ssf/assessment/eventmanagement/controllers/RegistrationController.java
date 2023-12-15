package vttp.ssf.assessment.eventmanagement.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.validation.Valid;
import vttp.ssf.assessment.eventmanagement.models.FormData;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;

@Controller
@RequestMapping("/home")
public class RegistrationController {

    @Autowired
    RedisRepository redisRepo;

    // TODO: Task 6
    @GetMapping("/register")
    public ModelAndView registerPage(@RequestParam MultiValueMap<String, Integer> params) {
        ModelAndView mav = new ModelAndView("eventregister");
        Integer eventId = params.getFirst("eventId");
        // List<Event> events = redisRepo.getEvent(eventId);

        mav.addObject("eventId", eventId);

        return mav;
    }

// TODO: Task 7
    @PostMapping("/submit-form")
    public String processRegistration(@Valid FormData formData, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "eventregister"; // Return to the form page with error messages
        }
        // if else
        // Process the form data (save to Redis) and if server side validation passes

        return "SuccessRegistration"; // Redirect to a success page

        // else if server side validation fails
        // return "ErrorRegistration"
    }
}