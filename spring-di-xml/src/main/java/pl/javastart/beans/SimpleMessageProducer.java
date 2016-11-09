package pl.javastart.beans;

public class SimpleMessageProducer implements MessageProducer {

	@Override
	public String getMessage() {
		return "Simple Message: " + System.currentTimeMillis();
	}

}
