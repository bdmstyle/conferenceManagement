package me.brunomarinho.model.track;

import java.time.LocalTime;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.brunomarinho.model.talk.Talk;

@Component
public class TrackTimeCalculator {
	
	@Autowired
	private TrackManager trackManager;

	public void calculateTimesforDay(int day) {
	   
		calculateMorningTimes(day);
		
		calculateEveningTimes(day);		
	}
	
	private void calculateMorningTimes(int day) {
		
		LocalTime currentTime = LocalTime.of(9, 0, 0);
		
		Iterator<Talk> trackIterator = trackManager.getMorningSession(day).iterator();
		
		calculateTimes(day, trackIterator, currentTime);
	}
	
	private void calculateEveningTimes(int day) {
		
		LocalTime currentTime = LocalTime.of(13, 0, 0);
		
		Iterator<Talk> trackIterator = trackManager.getEveningSession(day).iterator();
		
		calculateTimes(day, trackIterator, currentTime);

	}
	
	private void calculateTimes(int day,Iterator<Talk> trackIterator,LocalTime currentTime) {
		
		do{
			Talk track = trackIterator.next();
			track.setScheduledTime(currentTime);
			currentTime = currentTime.plusMinutes(track.getDuration());
		}while(trackIterator.hasNext());
	}

	

}
