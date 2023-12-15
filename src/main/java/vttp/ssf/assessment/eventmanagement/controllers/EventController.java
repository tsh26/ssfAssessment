package vttp.ssf.assessment.eventmanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;
import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@Controller
@RequestMapping
public class EventController {

	@Autowired
	RedisRepository redisRepo;

	@Autowired
	DatabaseService dbSvc;

	//TODO: Task 5
	@GetMapping({"/", "/view0.html"}) 
	public ModelAndView displayEvents() {
		ModelAndView mav = new ModelAndView("view0");
		mav.addObject("event1", redisRepo.getEvent(0));
		mav.addObject("event2", redisRepo.getEvent(1));
		mav.addObject("event3", redisRepo.getEvent(2));
		mav.addObject("event4", redisRepo.getEvent(3));

		return mav;		
	}

	@PostMapping("/register")
	public ModelAndView register() {
		ModelAndView mav = new ModelAndView("view1");
		mav.addObject("event1", redisRepo.getEvent(0));
		mav.addObject("event2", redisRepo.getEvent(1));
		mav.addObject("event3", redisRepo.getEvent(2));
		mav.addObject("event4", redisRepo.getEvent(3));

		return mav;

	}


}
