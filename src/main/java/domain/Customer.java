package domain;

import annotations.NotNullOrEmpty;
import annotations.SurnameNotName;

import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Created with IntelliJ IDEA.
 * User: janbartkowiak
 * Date: 11.10.13
 * Time: 17:14
 */
@SurnameNotName()
public class Customer {

    @NotNullOrEmpty
    @Pattern(regexp = "[A-Z][a-z]+")
    private String name;

    @NotNull
    @Size(max = 100)
    private String surname;

    @NotNull
    @Min(18)
    @Max(value = 125)
    private int age;

    @Valid
    private Address address;

    @Valid
    private ContactDetails contactDetails;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;

        Customer customer = (Customer) o;

        if (age != customer.age) return false;
        if (!name.equals(customer.name)) return false;
        if (!surname.equals(customer.surname)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + age;

        return result;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }
}
