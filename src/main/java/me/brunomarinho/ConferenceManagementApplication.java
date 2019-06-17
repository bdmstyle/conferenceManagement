package me.brunomarinho;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import me.brunomarinho.model.ConferenceManager;

@SpringBootApplication
public class ConferenceManagementApplication implements CommandLineRunner {
	
	@Autowired
	private ConferenceManager conferenceManager;

	public static void main(String[] args) {
		SpringApplication.run(ConferenceManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		conferenceManager.displayConference();
		
	}

}
