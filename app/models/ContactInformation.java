package models;

import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import play.db.jpa.Model;

import com.google.gson.annotations.Expose;

/**
 * 
 * @author Chrysa Papadaki - papadaki.chr@gmail.com
 * 
 */
@Embeddable
public class ContactInformation{

    @OneToOne
    //@Embedded
    public Location address;

    /**
     * 
     * @param telephone
     * @param mobile
     * @param email
     * @param addresses
     * @param website
     */
    public ContactInformation(String telephone, String mobile, String email,
        List<Location> addresses) {
        super();
        this.telephone = telephone;
        this.mobile = mobile;
        this.email = email;
        this.addresses = addresses;
    }
    /**
     * For external
     * @param telephone
     * @param mobile
     * @param email
     * @param address
     */
    public ContactInformation(String telephone, String mobile, String email,
            Location address, String website) {
            super();
            this.telephone = telephone;
            this.mobile = mobile;
            this.email = email;
            this.address = address;
            this.website = website;
        }
    
    /**
     * For customer
     * @param telephone
     * @param mobile
     * @param email
     * @param address
     */
    public ContactInformation(String telephone, String mobile, String email,
            Location address) {
            super();
            this.telephone = telephone;
            this.mobile = mobile;
            this.email = email;
            this.address = address;
        }
    /**
     * The telephone number - required
     */
    @Expose
    public String telephone;

    /**
     * The mobile number
     */
    @Expose
    public String mobile;

    /**
     * The email address - required
     */
    @Expose
    public String email;

    /**
     * Website of external technician - optional 
     */
    @Expose
    public String website;

    /**
     * The location of actor, for technician it is the location he/she can serve and for customer the
     * desirable meeting place
     */
    @Expose
    @OneToMany
    public List<Location> addresses;

}