package pl.javastart.app;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.javastart.beans.MessagePrinter;

public class SpringDiApplication {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-config.xml");
//		MessagePrinter printer = ctx.getBean(MessagePrinter.class);
//		MessagePrinter printer = (MessagePrinter) ctx.getBean("messagePrinter");
		MessagePrinter printer = ctx.getBean("messagePrinter", MessagePrinter.class);

		printer.print();
		ctx.close();
	}
}