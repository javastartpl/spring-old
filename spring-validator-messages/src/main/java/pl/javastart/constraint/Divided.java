package pl.javastart.constraint;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

import pl.javastart.validator.NumberDivideValidator;

@Documented
@Constraint(validatedBy = NumberDivideValidator.class)
@Target({ METHOD, FIELD, CONSTRUCTOR, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
public @interface Divided {
    String message() default "{pl.javastart.constraint.Divided.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
    
    int by() default 1;
}