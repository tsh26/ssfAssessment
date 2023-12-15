package vttp.ssf.assessment.eventmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@SpringBootApplication
public class EventmanagementApplication implements CommandLineRunner {

	@Autowired
	private DatabaseService dbSvc;
	public static void main(String[] args) {
		SpringApplication.run(EventmanagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<Event> events = dbSvc.readFile();

		System.out.println(">>> Event details" + events);
	}
	
	// TODO: Task 1

}
