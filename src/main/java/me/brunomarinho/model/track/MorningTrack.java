package me.brunomarinho.model.track;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import me.brunomarinho.model.talk.Talk;

@Component
public class MorningTrack implements TrackType{
	
	private int time=0;
	
	private int maxMorningHours = 180;
	
	private List<List<Talk>> morningTracks = new ArrayList<List<Talk>>();	
	
	@Override
	public boolean isValidSession(Talk track) {
		  
		  if(time + track.getDuration() <= maxMorningHours) {
			  time+=track.getDuration();
			  return true;
		  }else {
			  return false;
		  }
	  }
	
	@Override
	public boolean isValidSession() {
		return time == maxMorningHours;
	}

	@Override
	public void addValidSession(List<Talk> track) {
		morningTracks.add(track);
	}
	
	@Override
	public boolean isSessionCalculationNotDone(int numberOfConferenceDays) {
		return morningTracks.size() != numberOfConferenceDays;
	}

	@Override
	public void clean() {
		time = 0;
	}

	@Override
	public List<List<Talk>> getAllSessions() {
		return morningTracks;
	}

}
