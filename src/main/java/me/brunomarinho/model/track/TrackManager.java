package me.brunomarinho.model.track;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.brunomarinho.model.talk.Talk;
import me.brunomarinho.model.talk.TalkManager;

@Component
public class TrackManager {
	
	 @Autowired 
	 private MorningTrack morningTrack;
	  
	 @Autowired 
	 private EveningTrack eveningTrack;
	
	 @Autowired
  	 private TalkManager talkManager;
  
  	 public void calculateTracks() {
  		
		  List.of(morningTrack,eveningTrack).forEach(trackType -> {
		  
		  TrackProcessor trackProcessor = new TrackProcessor(trackType,talkManager);
		  
		  while (trackType.isSessionCalculationNotDone(numberOfConferenceDays())) {
		  
		  trackProcessor.proccessSession();
		  
		  } });

  	}
  	

	public List<Talk> getMorningSession(int day) {
		return morningTrack.getAllSessions().get(day);
	}

	public List<Talk> getEveningSession(int day) {
		return eveningTrack.getAllSessions().get(day);
	}
	
	/*
	 * 6 hours considering
	 * 9am - 12pm and 1pm - 5pm including networking
    */
    public int numberOfConferenceDays() {
    	int conferenceHours = 6; 
    	return  talkManager.getTotalTime() / (conferenceHours * 60 );
    }

}
