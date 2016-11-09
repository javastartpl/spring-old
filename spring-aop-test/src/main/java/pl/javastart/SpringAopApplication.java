package pl.javastart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import pl.javastart.service.MyBean;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class SpringAopApplication {
    public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				SpringAopApplication.class);
		
		MyBean bean = ctx.getBean(MyBean.class);
//		MyInterface bean = ctx.getBean(MyInterface.class); //works
		bean.myMethod();
		
		ctx.close();
	}
}