package domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: janbartkowiak
 * Date: 11.10.13
 * Time: 17:28
 */
public class Address {
    @NotEmpty
    private String city;

    @Pattern(regexp = "^\\d{5}")
    private String zip;

    @NotEmpty
    @Pattern(regexp = "[A-Z][a-z]+")
    private String street;

    @Pattern(regexp = "^\\d+[a-z]?")
    private String number;

    @NotEmpty
    private String addtionalDetails;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddtionalDetails() {
        return addtionalDetails;
    }

    public void setAddtionalDetails(String addtionalDetails) {
        this.addtionalDetails = addtionalDetails;
    }

    private boolean checkAddress() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;

        Address address = (Address) o;

        if (!addtionalDetails.equals(address.addtionalDetails)) return false;
        if (!city.equals(address.city)) return false;
        if (number != address.number) return false;
        if (street.equals(address.street)) return false;
        if (zip != address.zip) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + zip.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + number.hashCode();
        result = 31 * result + addtionalDetails.hashCode();

        return result;
    }
}
