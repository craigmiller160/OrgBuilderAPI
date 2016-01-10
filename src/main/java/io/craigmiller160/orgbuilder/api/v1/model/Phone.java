package io.craigmiller160.orgbuilder.api.v1.model;

import io.craigmiller160.orgbuilder.api.v1.util.StringUtil;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Model class that defines a phone
 * number.
 *
 * Created by Craig on 1/8/2016.
 */
public class Phone
implements Serializable{

    private static final long serialVersionUID = 717897495419589743L;

    /**
     * Unique identifier and database primary key
     * for this Phone.
     *
     * This field should NOT be assigned manually,
     * it should only be given a value consistent
     * with the keys in the database.
     */
    private Long phoneId;

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
     *
     * Phone number values are in Strings
     * because as numbers they might drop
     * digits.
     */
    private PhoneType phoneType;
    private String areaCode;
    private String prefix;
    private String lineNumber;
    private String extension;

    /**
     * Create a new Phone.
     */
    public Phone(){}

    /**
     * Create a phone with its field defined, but
     * with no extension.
     *
     * @param phoneType the type of phone number.
     * @param areaCode the phone number's area code.
     * @param prefix the phone number's prefix.
     * @param lineNumber the phone number's line number.
     */
    public Phone(PhoneType phoneType, String areaCode,
                 String prefix, String lineNumber){
        this(phoneType, areaCode, prefix, lineNumber, null);
    }

    /**
     * Create a phone with its fields defined,
     * including an extension.
     *
     * @param phoneType the type of phone number.
     * @param areaCode the phone number's area code.
     * @param prefix the phone number's prefix.
     * @param lineNumber the phone number's line number.
     * @param extension the phone number's extension.
     */
    public Phone(PhoneType phoneType, String areaCode,
                 String prefix, String lineNumber, String extension){
        this.phoneType = phoneType;
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
        this.extension = extension;
    }

    /**
     * Get the unique identifier for this
     * phone number.
     *
     * @return the unique ID for this phone.
     */
    public Long getPhoneId() {
        return phoneId;
    }

    /**
     * Set the unique identifier for this
     * phone number.
     *
     * @param phoneId the unique ID for this phone.
     */
    public void setPhoneId(Long phoneId) {
        this.phoneId = phoneId;
    }

    /**
     * Get the timestamp of when this phone
     * was last modified.
     *
     * @return the last modified timestamp.
     */
    public LocalDateTime getLastModified() {
        return lastModified;
    }

    /**
     * Set the timestamp of when this phone
     * was last modified.
     *
     * @param lastModified the last modified timestamp.
     */
    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    /**
     * Get the type of phone number.
     *
     * @return the type of phone number.
     */
    public PhoneType getPhoneType() {
        return phoneType;
    }

    /**
     * Set the type of phone number.
     *
     * @param phoneType the type of phone number.
     */
    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    /**
     * Get the phone number's area code.
     *
     * @return the phone number's area code.
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * Set the phone number's area code.
     *
     * @param areaCode the phone number's area code.
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * Get the phone number's prefix.
     *
     * @return the phone number's prefix.
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Set the phone number's prefix.
     *
     * @param prefix the phone number's prefix.
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Get the phone number's line number.
     *
     * @return the phone number's line number.
     */
    public String getLineNumber() {
        return lineNumber;
    }

    /**
     * Set the phone number's line number.
     *
     * @param lineNumber the phone number's line number.
     */
    public void setLineNumber(String lineNumber) {
        this.lineNumber = lineNumber;
    }

    /**
     * Get the phone number's extension.
     *
     * @return the phone number's extension.
     */
    public String getExtension() {
        return extension;
    }

    /**
     * Set the phone number's extension.
     *
     * @param extension the phone number's extension.
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Phone phone = (Phone) o;

        if (phoneType != phone.phoneType) return false;
        if (areaCode != null ? !areaCode.equals(phone.areaCode) : phone.areaCode != null) return false;
        if (prefix != null ? !prefix.equals(phone.prefix) : phone.prefix != null) return false;
        //noinspection SimplifiableIfStatement
        if (lineNumber != null ? !lineNumber.equals(phone.lineNumber) : phone.lineNumber != null) return false;
        return !(extension != null ? !extension.equals(phone.extension) : phone.extension != null);

    }

    @Override
    public int hashCode() {
        int result = phoneType != null ? phoneType.hashCode() : 0;
        result = 31 * result + (areaCode != null ? areaCode.hashCode() : 0);
        result = 31 * result + (prefix != null ? prefix.hashCode() : 0);
        result = 31 * result + (lineNumber != null ? lineNumber.hashCode() : 0);
        result = 31 * result + (extension != null ? extension.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();

        if(StringUtil.ensureStringExists(areaCode)){
            builder.append("(").append(areaCode).append(") ");
        }

        if(StringUtil.ensureStringExists(prefix)){
            builder.append(prefix).append("-");
        }

        if(StringUtil.ensureStringExists(lineNumber)){
            builder.append(lineNumber);
        }

        if(StringUtil.ensureStringExists(extension)){
            builder = StringUtil.ensureEndsWithSpace(builder);
            builder.append("x").append(extension);
        }

        return builder.toString();
    }

    /**
     * The types of phone numbers supported
     * by this model.
     */
    public enum PhoneType{
        FAX,
        HOME,
        MOBILE,
        OTHER,
        WORK
    }

}
