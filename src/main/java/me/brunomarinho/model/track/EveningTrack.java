package me.brunomarinho.model.track;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import me.brunomarinho.model.talk.Talk;

@Component
public class EveningTrack implements TrackType{
	
	private int time=0;
	
	private int minEveningSessionTimeLimit = 180;
	  
	private int maxEveningSessionTimeLimit = 240;
	
	private List<List<Talk>> eveningTracks = new ArrayList<List<Talk>>();	

	@Override
	public boolean isValidSession(Talk track) {
		  
		  if(time + track.getDuration() < maxEveningSessionTimeLimit) {
			  time+=track.getDuration();
			  return true;
		  }else {
			  return false;
		  }
	}

	@Override
	public boolean isValidSession() {
		 return time >= minEveningSessionTimeLimit && time < maxEveningSessionTimeLimit;
	}

	@Override
	public void clean() {
		  time=0;
	}
	
	@Override
	public boolean isSessionCalculationNotDone(int numberOfConferenceDays) {
			return eveningTracks.size() != numberOfConferenceDays;
	}

	@Override
	public void addValidSession(List<Talk> track) {
		eveningTracks.add(track);
		
	}

	@Override
	public List<List<Talk>> getAllSessions() {
		return eveningTracks;
	}

}
