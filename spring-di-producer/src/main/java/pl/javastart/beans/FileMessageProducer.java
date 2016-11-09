package pl.javastart.beans;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import pl.javastart.beans.Message.MessageType;

@Component
//@Qualifier("fileMessageProducer")
@Message(type = MessageType.FILE)
public class FileMessageProducer implements MessageProducer {

	@Autowired
	@Qualifier("messageFile")
	private String fileName;
	
	@Override
	public String getMessage() {
		List<String> lines = null;
		try {
			Path path = new File(getClass().getResource(fileName).toURI()).toPath();
			lines = Files.readAllLines(path);
		} catch (URISyntaxException | IOException e) {
			e.printStackTrace();
		}
		String result = "";
		if (lines != null)
			result = lines.stream().reduce(result, (a, b) -> a + b);
		return result;
	}

}
