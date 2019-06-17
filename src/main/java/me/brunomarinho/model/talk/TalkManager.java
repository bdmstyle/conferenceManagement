package me.brunomarinho.model.talk;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import me.brunomarinho.io.FileHandler;

@Data
@Component
public class TalkManager {
	
	@Autowired
	private FileHandler fileHandler;
	
	private List<Talk> ordenedTalks;
	
	@PostConstruct
	void loadOrdenedListOfTalks() {
		ordenedTalks = fileHandler
				.getLines()
				.stream()
				.map(line -> new Talk(line, getName(line), getDuration(line)))
				.sorted()
				.collect(toList());
	}
	
	public int getTotalTime() {
		return ordenedTalks
				.stream()
				.mapToInt(task -> task.getDuration())
				.sum();
	}

	public List<Talk> scheduleAll(List<Talk> tasks) {
		  return ordenedTalks
				  .stream()
				  .filter(track -> tasks.contains(track))
				  .map(track -> track.schedule())
				  .collect(Collectors.toList());
	}

	private String getName(String talk) {
		return talk.substring(0, talk.lastIndexOf(" "));
	}
	
	private int getDuration(String line) {
		
		String timeString = line.substring(line.lastIndexOf(" ") + 1);

		if(timeString.equals("lightning")) {
			return 5;
		}else {
			return parseInt(timeString.substring(0, timeString.indexOf("min")));
		}
	
	}
	

}
