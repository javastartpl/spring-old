package pl.javastart.beans.producers;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

@Target({ElementType.FIELD,
    ElementType.METHOD,
    ElementType.TYPE,
    ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Producer {

	ProducerType type();
	
	public enum ProducerType {
		SIMPLE, FILE;
	}
}
