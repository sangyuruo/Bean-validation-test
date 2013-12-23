package validators;

import annotations.SurnameNotName;
import domain.Customer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * Created with IntelliJ IDEA.
 * User: janbartkowiak
 * Date: 11.10.13
 * Time: 17:42
 */
public class SurnameNotNameValidator implements ConstraintValidator<SurnameNotName, Customer> {

    @Override
    public void initialize(SurnameNotName constraintAnnotation) {
    }

    @Override
    public boolean isValid(Customer value, ConstraintValidatorContext context) {
        return value.getName().equalsIgnoreCase(value.getSurname()) ? false : true;
    }
}
