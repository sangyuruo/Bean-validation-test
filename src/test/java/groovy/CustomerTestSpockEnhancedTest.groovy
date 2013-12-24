package groovy

import domain.Customer
import spock.lang.Specification

import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory
/**
 * Created with IntelliJ IDEA.
 * User: janbartkowiak
 * Date: 31.10.13
 * Time: 16:52
 */
class CustomerTestSpockEnhancedTest extends Specification {

    private static Validator validator;

    // Doing meta stuff like setup or cleanup the mess
    def setupSpec() {}

    def setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    def cleanup() {}

    def cleanupSpec() {}

    // Real testing
    def "Validation of simple customer data"() {
        setup:
        def customer = new Customer(
                name: 'Jan',
                surname: 'Bartkowiak',
                age: 33)

        when:
        Set<ConstraintViolation<Customer>> validationResults = validator.validate(customer)

        then:
        validationResults.empty
    }

    def "Validation of multiple customer data"() {
        expect: "Validation expects no unexpected validation failures"
        validator.validate(validatioResults).size() == validation

        where:
        validatioResults                                          | validation
        new Customer(name: 'Jan', surname: 'Bartkowiak', age: 33) | 0
        new Customer(name: 'Jan', surname: 'Jan', age: 33)        | 1
    }
}
