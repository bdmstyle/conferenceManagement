package me.brunomarinho.model.track;

import java.util.List;

import me.brunomarinho.model.talk.Talk;

public interface TrackType {

	 boolean isValidSession(Talk track);
	 
	 boolean isValidSession();
	
	 void clean();
	 
	 void addValidSession(List<Talk> track);
	 
	 List<List<Talk>> getAllSessions();
	 
	 boolean isSessionCalculationNotDone(int numberOfConferenceDays);
}
