package me.brunomarinho.model.track;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import me.brunomarinho.model.talk.Talk;
import me.brunomarinho.model.talk.TalkManager;

public class TrackProcessor {

	private int currentIndex=0;
	
	private List<Talk> itemsToProcess;
	
	private TrackType trackType;
	
	private TalkManager talkManager;
		
	public TrackProcessor(TrackType trackType,TalkManager talkManager) {
		this.trackType = trackType;
		this.talkManager=talkManager;
	}

	public void proccessSession() {
		
		itemsToProcess = 
				talkManager
				.getOrdenedTalks()
				.stream()
				.filter(track -> !track.isScheduled())
				.skip(currentIndex)
				.collect(toList());
		
		List<Talk> validTracks = new ArrayList<Talk>();

		  itemsToProcess.stream().forEach(track -> {
			  
			  if(trackType.isValidSession(track)) {
				 validTracks.add(track);
			  }
			  
		  });
		  
		  currentIndex++;
		  	  
		  if(trackType.isValidSession()) {
			  trackType.clean();
			  currentIndex=0;
			  trackType.addValidSession(validTracks);
			  talkManager.scheduleAll(validTracks);
		  }else {
			  trackType.clean();
		  }
		
	}
	
}
