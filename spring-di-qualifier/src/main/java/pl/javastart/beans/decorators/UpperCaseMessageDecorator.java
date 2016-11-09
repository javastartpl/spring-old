package pl.javastart.beans.decorators;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class UpperCaseMessageDecorator implements MessageDecorator {
	@Override
	public String decorate(String msg) {
		return msg.toUpperCase();
	}
}