package me.brunomarinho.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.brunomarinho.model.track.TrackManager;
import me.brunomarinho.model.track.TrackRender;

@Component
public class ConferenceManager {
	
	@Autowired
	private TrackManager trackManager;
	
	@Autowired
	private TrackRender trackRender;
	
    public void displayConference() {
    	
		trackManager.calculateTracks();
		
		trackRender.renderTracks();
			
    }
    


}
