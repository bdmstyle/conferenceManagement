package me.brunomarinho.io;

import static java.util.stream.Collectors.toList;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class FileHandler {
	
	@Value("classpath:source.txt")
	private Resource filename ;
	
    public List<String> getLines(){
     
        try (Stream<String> stream = Files.lines(Paths.get(filename.getURI()))) {
                return stream
                		.skip(1) // number of lines is not used
                		.collect(toList());
        } catch (IOException e) {
			throw new RuntimeException("Error Reading File");
		}
    }

}



