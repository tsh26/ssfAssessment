package vttp.ssf.assessment.eventmanagement.services;

import java.io.FileReader;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonReader;
import vttp.ssf.assessment.eventmanagement.models.Event;

@Service
public class DatabaseService {

    // TODO: Task 1

    // Check if the events have been fetched before
    private List<Event> events = null;

    public List<Event> readFile() {
        if (events == null) {
            try (JsonReader reader = Json.createReader(new FileReader(
                    "events.json"))) {
                // Reads the Json array
                JsonArray arr = reader.readArray();

                // Mapping each JASON object to an Event object:
                events = arr.stream()
                        .map(j -> j.asJsonObject())
                        .map(o -> {
                            int eventId = o.getInt("eventId");
                            String eventName = o.getString("eventName");
                            int eventSize = o.getInt("eventSize");
                            int eventDate = o.getInt("eventDate");
                            int participants = o.getInt("participants");

                            return new Event(eventId, eventName, eventSize, eventDate, participants);
                        })
                        .toList();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }
        return events;
    }

}
