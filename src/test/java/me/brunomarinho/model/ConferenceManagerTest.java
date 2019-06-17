package me.brunomarinho.model;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import me.brunomarinho.model.ConferenceManager;
import me.brunomarinho.model.track.TrackManager;
import me.brunomarinho.model.track.TrackRender;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class ConferenceManagerTest {
	
	@Mock
	private TrackManager trackManager;
	
	@Mock
	private TrackRender trackRender;
	
	@InjectMocks
	private ConferenceManager conferenceManager;
	
	@Test
	public void contextLoads() {
		
		doNothing().when(trackManager).calculateTracks();
	
		doNothing().when(trackRender).renderTracks();
		
		conferenceManager.displayConference();
		
		verify(trackManager,times(1)).calculateTracks();
		
		verify(trackRender,times(1)).renderTracks();
		
	}

}
