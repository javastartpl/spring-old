package pl.javastart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import pl.javastart.beans.MyInterface;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SpringAopProxyApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(SpringAopProxyApplication.class, args);
		MyInterface bean = ctx.getBean(MyInterface.class);
		bean.doAction();
		System.out.println(bean.getClass());
		ctx.close();
	}
}
