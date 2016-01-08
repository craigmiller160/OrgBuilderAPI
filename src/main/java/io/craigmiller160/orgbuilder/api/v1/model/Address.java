package io.craigmiller160.orgbuilder.api.v1.model;

import java.time.LocalDateTime;

/**
 * Model class that defines an address. Used
 * as an attribute of people objects, as well
 * as location based entities.
 *
 * Created by Craig on 1/7/2016.
 */
public class Address {

    //TODO create subclass for PersonAddress, with a person field that owns it.

    /**
     * The address ID, the primary key of the
     * database table.
     *
     * This field should NOT be assigned manually,
     * it should be given a value consistent with
     * the keys in the database table.
     */
    private Long addressId;

    /**
     * A timestamp for when the address was last
     * modified.
     */
    private LocalDateTime lastModified;

    /**
     * The type of address this is.
     */
    private AddressType addressType;

    /**
     * The house number and street name.
     */
    private String streetAddress;

    /**
     * The PO Box.
     */
    private String poBox;

    /**
     * The unit/apartment number.
     */
    private String unit;

    /**
     * The city name.
     */
    private String city;

    /**
     * The state.
     */
    private State state;

    /**
     * The zip code.
     */
    private String zip;

    /**
     * Build an <tt>Address</tt> object.
     */
    public Address(){}

    /**
     * Build an <tt>Address</tt> object that
     * is a standard house address.
     *
     * @param addressType the type of address this is.
     * @param streetAddress the house number and street name.
     * @param city the city name.
     * @param state the state.
     * @param zip the zip code.
     */
    public Address(AddressType addressType, String streetAddress, String city, State state, String zip){
        this(addressType, streetAddress, null, city, state, zip);
    }

    /**
     * Build an <tt>Address</tt> object that
     * is a standard apartment address.
     *
     * @param addressType the type of address this is.
     * @param streetAddress the house number and street name.
     * @param unit the unit/apartment number.
     * @param city the city name.
     * @param state the state.
     * @param zip the zip code.
     */
    public Address(AddressType addressType, String streetAddress, String unit, String city, State state, String zip){
        this.addressType = addressType;
        this.streetAddress = streetAddress;
        this.unit = unit;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    /**
     * Get the ID of this model.
     *
     * @return the ID.
     */
    public Long getAddressId() {
        return addressId;
    }

    /**
     * Set the ID of this model.
     *
     * @param addressId the ID.
     */
    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    /**
     * Get the last modified timestamp.
     *
     * @return the last modified timestamp.
     */
    public LocalDateTime getLastModified() {
        return lastModified;
    }

    /**
     * Set the last modified timestamp.
     *
     * @param lastModified the last modified timestamp.
     */
    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    /**
     * Get the type of address this is.
     *
     * @return the type of address.
     */
    public AddressType getAddressType() {
        return addressType;
    }

    /**
     * Set the type of address this is.
     *
     * @param addressType the type of address
     */
    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    /**
     * Get the house number and street name.
     *
     * @return the house number and street name.
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Set the house number and street name.
     *
     * @param streetAddress the house number and street name.
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * Get the PO Box.
     *
     * @return the PO Box.
     */
    public String getPoBox() {
        return poBox;
    }

    /**
     * Set the PO Box.
     *
     * @param poBox the PO Box.
     */
    public void setPoBox(String poBox) {
        this.poBox = poBox;
    }

    /**
     * Get the unit/apartment number.
     *
     * @return the unit/apartment number.
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Set the unit/apartment number.
     *
     * @param unit the unit/apartment number.
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * Get the city name.
     *
     * @return the city name.
     */
    public String getCity() {
        return city;
    }

    /**
     * Set the city name.
     *
     * @param city the city name.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Get the state.
     *
     * @return the state.
     */
    public State getState() {
        return state;
    }

    /**
     * Set the state.
     *
     * @param state the state.
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * Get the zip code.
     *
     * @return the zip code.
     */
    public String getZip() {
        return zip;
    }

    /**
     * Set the zip code.
     *
     * @param zip the zip code.
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * The types of addresses supported
     * by this model.
     */
    @SuppressWarnings("unused")
    public enum AddressType{
        HOME,
        WORK,
        MAIL,
        OTHER
    }

}
