package me.brunomarinho.model.talk;

import static java.text.MessageFormat.format;

import java.time.LocalTime;

import lombok.Data;

@Data
public class Talk implements Comparable<Talk>{
	
    private String title;
    private String name;
    private Integer duration;
    private boolean scheduled;
    private LocalTime scheduledTime;
   
	public Talk(String title, String name, int duration) {
        this.title = title;
        this.name = name;
        this.duration = duration;
    }

    public Talk schedule() {
    	scheduled=true;
        return this;
    }

	@Override
    public String toString() {
    	return format("{0} - {1} mins - Scheduled={2}",name,duration,scheduled,scheduledTime);
    }
	
	@Override 
	public int compareTo(Talk talk){ 
		 return  talk.getDuration().compareTo(duration);
	}

}


