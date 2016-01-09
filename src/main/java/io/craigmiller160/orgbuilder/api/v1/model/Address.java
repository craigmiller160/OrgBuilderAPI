package io.craigmiller160.orgbuilder.api.v1.model;

import io.craigmiller160.orgbuilder.api.v1.util.StringUtil;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Model class that defines an address. Used
 * as an attribute of people objects, as well
 * as location based entities.
 *
 * Created by Craig on 1/7/2016.
 */
public class Address
implements Serializable {

    private static final long serialVersionUID = 572498598156134080L;

    //TODO create subclass for PersonAddress, with a person field that owns it.

     /**
     * Unique identifier and database primary key
     * for this Address.
     *
     * This field should NOT be assigned manually,
     * it should only be given a value consistent
     * with the keys in the database.
     */
    private Long addressId;

    /**
     * A timestamp for when the address was last
     * modified.
     *
     * This field should be assigned right before
     * each persistence operation.
     */
    private LocalDateTime lastModified;

    /*
     * The fields for the values of the
     * address.
     */
    private AddressType addressType;
    private String streetAddress;
    private String poBox;
    private String unit;
    private String city;
    private State state;
    private String zip;

    /**
     * Build an Address object.
     */
    public Address(){}

    /**
     * Build an Address object that
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
     * Build an Address object that
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (addressType != address.addressType) return false;
        if (streetAddress != null ? !streetAddress.equals(address.streetAddress) : address.streetAddress != null)
            return false;
        if (poBox != null ? !poBox.equals(address.poBox) : address.poBox != null) return false;
        if (unit != null ? !unit.equals(address.unit) : address.unit != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        //noinspection SimplifiableIfStatement
        if (state != address.state) return false;
        return !(zip != null ? !zip.equals(address.zip) : address.zip != null);

    }

    @Override
    public int hashCode() {
        int result = addressType != null ? addressType.hashCode() : 0;
        result = 31 * result + (streetAddress != null ? streetAddress.hashCode() : 0);
        result = 31 * result + (poBox != null ? poBox.hashCode() : 0);
        result = 31 * result + (unit != null ? unit.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (zip != null ? zip.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        if(StringUtil.ensureStringExists(poBox)){
            builder.append(poBox);
        }

        if(StringUtil.ensureStringExists(streetAddress)){
            builder = StringUtil.ensureEndsWithSpace(builder);
            builder.append(streetAddress);
        }

        if(StringUtil.ensureStringExists(unit)){
            builder = StringUtil.ensureEndsWithSpace(builder);
            builder.append(unit);
        }

        if(StringUtil.ensureStringExists(city)){
            builder = StringUtil.ensureEndsWithCommaSpace(builder);
            builder.append(city);
        }

        if(state != null){
            builder = StringUtil.ensureEndsWithCommaSpace(builder);
            builder.append(state.toString());
        }

        if(StringUtil.ensureStringExists(zip)){
            builder = StringUtil.ensureEndsWithSpace(builder);
            builder.append(zip);
        }

        return builder.toString();
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
