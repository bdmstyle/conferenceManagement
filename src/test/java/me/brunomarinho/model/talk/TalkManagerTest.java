package me.brunomarinho.model.talk;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.javafaker.Faker;

import me.brunomarinho.io.FileHandler;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TalkManagerTest {
	
	@Mock
	private FileHandler fileHandler;
	
	@InjectMocks
	private TalkManager talkManager;
	
	Faker faker = new Faker();
	
	@Test
	public void testGetOrdenedTalks() {
		
		List<String> unordenedList = List.of("Overdoing it in Java 45min","Writing Fast Tests Using Selenium 60min","Rails for Java Developers lightning");
		
		when(fileHandler.getLines()).thenReturn(unordenedList);
		
		talkManager.loadOrdenedListOfTalks();
		
		List<Talk> ordenedList = Arrays.asList(
				new Talk("Writing Fast Tests Using Selenium 60min", "Writing Fast Tests Using Selenium", 60),
				new Talk("Overdoing it in Java 45min", "Overdoing it in Java", 45),
				new Talk("Rails for Java Developers lightning","Rails for Java Developers", 5));
		
		assertEquals(talkManager.getOrdenedTalks(), ordenedList);
		
	}
	
	@Test
	public void testTotalTime() {
		
        List<String> unordenedList = List.of("Overdoing it in Java 45min","Writing Fast Tests Using Selenium 60min","Rails for Java Developers lightning");
		
		when(fileHandler.getLines()).thenReturn(unordenedList);
		
		talkManager.loadOrdenedListOfTalks();
		
		assertThat(talkManager.getTotalTime(),equalTo(110));

	}
	
	@Test
	public void testScheduleTest() {
		
        List<String> unordenedList = List.of("Overdoing it in Java 45min","Writing Fast Tests Using Selenium 60min","Rails for Java Developers lightning");
		
		when(fileHandler.getLines()).thenReturn(unordenedList);
		
		talkManager.loadOrdenedListOfTalks();
		
		List<Talk> tasksToSchedule = Arrays.asList(
				new Talk("Overdoing it in Java 45min", "Overdoing it in Java", 45),
				new Talk("Rails for Java Developers lightning","Rails for Java Developers", 5));
		
		talkManager.scheduleAll(tasksToSchedule);
		
		assertThat(talkManager.getOrdenedTalks().get(0).isScheduled(),equalTo(false));
		assertThat(talkManager.getOrdenedTalks().get(1).isScheduled(),equalTo(true));
		assertThat(talkManager.getOrdenedTalks().get(2).isScheduled(),equalTo(true));
	

	}
	
	
}
