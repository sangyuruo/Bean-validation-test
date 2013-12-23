package annotations;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotNull;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created with IntelliJ IDEA.
 * User: janbartkowiak
 * Date: 31.10.13
 * Time: 16:30
 */
@Constraint(validatedBy = {})
@NotNull
@NotEmpty
@Target({FIELD, METHOD})
@Retention(RUNTIME)
public @interface NotNullOrEmpty {
    String message() default "{de.bartkowiak.NotNullOrEmpty.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
