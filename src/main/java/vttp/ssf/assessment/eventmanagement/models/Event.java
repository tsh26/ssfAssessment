package vttp.ssf.assessment.eventmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private int eventId;
    private String eventName;
    private int eventSize;
    private int eventDate;
    private int participants;
}
