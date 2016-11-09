package pl.javastart.component;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Component;

import pl.javastart.model.Participant;

@Component
public class EventHolder {

    private List<Participant> participants;
    
    public EventHolder() {
        participants = new LinkedList<>();
    }
    
    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    public List<Participant> getParticipants() {
        return participants;
    }
    
    public boolean checkRegistration(Participant participant) {
        return participants.contains(participant);
    }
}