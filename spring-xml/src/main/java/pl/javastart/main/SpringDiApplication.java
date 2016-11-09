package pl.javastart.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.javastart.beans.MessagePrinter;

public class SpringDiApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beansConfig.xml");
		MessagePrinter printer = ctx.getBean(MessagePrinter.class);
		printer.print();
		ctx.close();
	}
}