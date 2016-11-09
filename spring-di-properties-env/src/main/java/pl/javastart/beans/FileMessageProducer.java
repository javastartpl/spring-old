package pl.javastart.beans;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import pl.javastart.beans.Message.MessageType;

@Component
@Message(type = MessageType.FILE)
@PropertySource("classpath:appConfig.properties")
public class FileMessageProducer implements MessageProducer {

	@Autowired
	Environment env;

	@Override
	public String getMessage() {
		List<String> lines = null;
		try {
			String fileName = env.getProperty("messageFileProperty");
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