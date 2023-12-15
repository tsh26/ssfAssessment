package vttp.ssf.assessment.eventmanagement.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event {
    private Integer eventId;
    private String eventName;
    private Integer eventSize;
    private long eventDate;
    private Integer participants;
}
