package domain;

import javax.validation.constraints.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: janbartkowiak
 * Date: 22.12.13
 * Time: 21:25
 */
public class ContactDetails {
    @Pattern(regexp = "\\+?\\d{0,4}", message = "{countryCode.message}")
    private String countryCode;
    @Pattern(regexp = "^\\d{3,6}", message = "areaCode.message")
    private String areaCode;
    @Pattern(regexp = "^\\d{4,}", message = "telephoneNumber.message")
    private String telephoneNumber;
    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$", message = "{emailAddress.message}")
    private String emailAddress;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
