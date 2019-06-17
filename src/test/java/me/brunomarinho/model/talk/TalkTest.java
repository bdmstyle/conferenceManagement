package me.brunomarinho.model.talk;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.javafaker.Faker;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class TalkTest {
	
	Faker faker = new Faker();
	
	@Test
	public void createTalk() {
		
		String title = faker.name().firstName();
		String name = faker.name().lastName();
		int duration = faker.number().numberBetween(0, 60);
		
		Talk talk = new Talk(title, name, duration);
		
		assertThat(talk.getTitle(),equalTo(title));
		assertThat(talk.getName(),equalTo(name));
		assertThat(talk.getDuration(),equalTo(duration));
		
	}
	
	@Test
	public void scheduleTalk() {
		
		String title = faker.name().firstName();
		String name = faker.name().lastName();
		int duration = faker.number().numberBetween(0, 60);
		
		Talk talk = new Talk(title, name, duration);
		
		Talk scheduleResult = talk.schedule();
		
		assertThat(talk.isScheduled(),equalTo(true));
		assertThat(talk,equalTo(scheduleResult));
		
	}
	
	@Test
	public void talkToString() {
		
		String title = faker.name().firstName();
		String name = faker.name().lastName();
		int duration = faker.number().numberBetween(0, 60);
		
		Talk talk = new Talk(title, name, duration);
		
		assertThat(talk.toString(),equalTo(name+" - "+duration+" mins - Scheduled="+talk.isScheduled()));
		
	}
	
	@Test
	public void talkCompareToInversed() {
		
		String title = faker.name().firstName();
		String name = faker.name().lastName();
		int duration = 30;
		int duration2 = 60;
		
		Talk talk = new Talk(title, name, duration);
		Talk talk2 = new Talk(title, name, duration2);
		
		assertThat(talk.compareTo(talk2),equalTo(1));
		
	}
	
}
