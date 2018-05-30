package pl.javastart.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pl.javastart.beans.MessagePrinter;

public class SpringDiApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(ApplicationConfig.class);
		MessagePrinter printer = ctx.getBean(MessagePrinter.class);
		printer.print();
		ctx.close();
	}
}
