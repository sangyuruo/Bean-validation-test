package annotations;

import validators.SurnameNotNameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created with IntelliJ IDEA.
 * User: janbartkowiak
 * Date: 11.10.13
 * Time: 17:38
 */
@Constraint(validatedBy = SurnameNotNameValidator.class)
@Target({TYPE})
@Retention(RUNTIME)
public @interface SurnameNotName {
    String message() default "{de.bartkowiak.SurnameNotName.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
