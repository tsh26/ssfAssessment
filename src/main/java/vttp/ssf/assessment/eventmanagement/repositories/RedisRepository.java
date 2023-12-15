package vttp.ssf.assessment.eventmanagement.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import vttp.ssf.assessment.eventmanagement.models.Event;

@Repository
public class RedisRepository {

	private final List<Event> events;
	private RedisTemplate<String, String> template;

	public RedisRepository(List<Event> events, @Qualifier("repo") RedisTemplate<String, String> template) {
		this.events = events;
		this.template = template;
	}

	// TODO: Task 2
	public void saveRecord(Event event) {
		events.add(event);

		String key = "events:" + event.getEventId();
		template.opsForValue().set(key, event.toString());
	}

	// TODO: Task 3
	public int getNumberOfEvents() {
		int size = events.size();

		return size;
	}

	// TODO: Task 4
	public Event getEvent(int eventId) {
		Event specificEvent = events.get(eventId);
		
		return specificEvent;
	}
}
