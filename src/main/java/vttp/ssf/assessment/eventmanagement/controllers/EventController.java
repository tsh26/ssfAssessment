package vttp.ssf.assessment.eventmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;

@Controller
@RequestMapping("/events")
public class EventController {

	@Autowired
	RedisRepository redisRepo;

	// TODO: Task 5
	@GetMapping("/listing")
	public ModelAndView displayEvents() {
		ModelAndView mav = new ModelAndView("view0");
		// List<Event> events = redisRepo.getEvent(null);
		mav.addObject("event1", redisRepo.getEvent(0));
		mav.addObject("event2", redisRepo.getEvent(1));
		mav.addObject("event3", redisRepo.getEvent(2));
		mav.addObject("event4", redisRepo.getEvent(3));

		return mav;
	}

	// @GetMapping("/register")
    // public ModelAndView registerPage(@RequestParam MultiValueMap<String, Integer> params) {
    //     ModelAndView mav = new ModelAndView("eventregister");
    //     Integer eventId = params.getFirst("eventId");
    //     // List<Event> events = redisRepo.getEvent(eventId);

    //     mav.addObject("eventId", eventId);

    //     return mav;

	// }
}