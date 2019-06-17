package me.brunomarinho.model.track;

import static java.util.stream.IntStream.range;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.brunomarinho.model.talk.Talk;

@Component
public class TrackRender {
	
	@Autowired
	private TrackManager trackManager;
	
	@Autowired
	private TrackTimeCalculator trackTimeCalculator;
	
	public void renderTracks() {
		range(0, trackManager.numberOfConferenceDays())
		.forEach(day -> render(day));
	}
	
	public void render(int day) {
		
		trackTimeCalculator.calculateTimesforDay(day);
		
		renderTrackName(day);
		
		renderMorningTalks(day);
		
		renderLunchTime();
		
		renderEveningTalks(day);
		
		renderNetworkingTime(day);
		
	}

	private void renderNetworkingTime(int day) {
		List<Talk> eveningSession = trackManager.getEveningSession(day);
		Talk last = eveningSession.get(eveningSession.size()-1);
		System.out.println(last.getScheduledTime().plusMinutes(last.getDuration())+"PM Networking Event");
	}

	
	private void renderEveningTalks(int day) {
		trackManager
			.getEveningSession(day)
			.forEach(track -> renderTrackLine(track,"PM"));
	}

	private void renderMorningTalks(int day) {
		trackManager
			.getMorningSession(day)
			.forEach(track -> renderTrackLine(track,"AM"));
	}

	private void renderTrackLine(Talk track,String period) {
		System.out.println(track.getScheduledTime()+period+" "+track.getTitle());
	}
	

	private void renderTrackName(int day) {
		System.out.println("Track "+trackNumber(day)+":");
	}
	
	private int trackNumber(int day) {
		return day+1;
	}

	private void renderLunchTime() {
		System.out.println("12:00PM Lunch");
	}



}
