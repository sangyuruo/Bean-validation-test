package groovy

import domain.Address
import domain.ContactDetails
import domain.Customer
import junit.framework.Assert
import org.junit.Before
import org.junit.Test

import javax.validation.ConstraintViolation
import javax.validation.Validation
import javax.validation.Validator
import javax.validation.ValidatorFactory
import javax.validation.groups.Default

/**
 * Created with IntelliJ IDEA.
 * User: janbartkowiak
 * Date: 11.11.13
 * Time: 09:20
 */
class CustomerOldJavaTest {
    private static Validator validator;

    private Customer customer;
    private Address address;
    private ContactDetails contactDetails;

    @Before
    public void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();

    }

    @Test
    public void testValidation() throws Exception {
        customer = new Customer();
        customer.setAge(125);
        customer.setName("Bartkowiak");
        customer.setSurname("Jan");

        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);

        Assert.assertTrue(constraintViolations.isEmpty());
    }

    @Test
    public void testValidation_ExpectsErrorMessage() throws Exception {
        customer = new Customer();
        customer.setAge(125);
        customer.setName("Same");
        customer.setSurname("Same");

        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);

        Assert.assertTrue(constraintViolations.size() == 1);
    }

    @Test
    public void testValidationForMember_ExpectsNoErrorMessage() {
        customer = new Customer();
        customer.setAge(125);
        customer.setName("Jan");
        // Validation should break here - equal name and surename
        customer.setSurname("Jan");

        Set<ConstraintViolation<Customer>> constraintViolations = validator.validateProperty(customer, "age", Default.class);

        Assert.assertTrue(constraintViolations.isEmpty());
    }

    @Test
    public void testValidationForClassWithMemberAndThreeErrors_ExpectsThreeErrorMessage() {
        address = new Address();
        address.city = "Aschaffenburg";
        address.street = "Heckenweg";
        address.zip = "63743";
        // Constraint violation 1 - space not allowed
        address.number = " 1111a";
        address.addtionalDetails = "Somewhere in nowhere ...";

        contactDetails = new ContactDetails();
        contactDetails.setAreaCode("176");
        // Constraint violation 2 - only +49, 0049 or +0049 supported
        contactDetails.setCountryCode("+00049")
        contactDetails.setTelephoneNumber("10497898");
        contactDetails.setEmailAddress("info@bartkowiak-consulting.de");

        customer = new Customer();
        // Constraint violation 3 - maximum age of 125 set
        customer.setAge(126);
        customer.setName("Jan");
        customer.setSurname("Bartkowiak");
        customer.address = address;
        customer.contactDetails = contactDetails;

        Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);

        Assert.assertFalse(constraintViolations.isEmpty());
        Assert.assertTrue(constraintViolations.size().equals(3))
    }
}
