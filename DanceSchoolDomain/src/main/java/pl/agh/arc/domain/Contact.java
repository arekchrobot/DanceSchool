package pl.agh.arc.domain;

import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * @author chrobota
 */
@Entity
@Table(name = "contact")
@SequenceGenerator(name = "default_gen", sequenceName = "contact_seq", allocationSize = 1)
public class Contact extends BaseEntity {

    private static final long serialVersionUID = -6905146362478976885L;

    @Column(name = "address", length = 100)
    @Size(max = 100)
    private String address;

    @Column(name = "zip_code", length = 10)
    @Size(max = 10)
    private String zipCode;

    @Column(name = "city", length = 50)
    @Size(max = 50)
    private String city;

    @Column(name = "phone", length = 30)
    @Size(max = 30)
    private String phone;

    @Column(name = "email", length = 100)
    @Email
    @Size(max = 100)
    private String email;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "opening_hours",
            joinColumns = @JoinColumn(name = "contact_id"))
    @Column(name = "opening_hour")
    private List<String> openingHours;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(List<String> openingHours) {
        this.openingHours = openingHours;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
