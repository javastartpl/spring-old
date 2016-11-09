package pl.javastart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import pl.javastart.beans.MessagePrinter;

@Configuration
@ComponentScan
public class SpringDiApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringDiApplication.class);

        MessagePrinter bean1 = ctx.getBean(MessagePrinter.class);
        bean1.printMessage();
        MessagePrinter bean2 = ctx.getBean(MessagePrinter.class);
        bean2.printMessage();
        
        ctx.close();
    }
}
