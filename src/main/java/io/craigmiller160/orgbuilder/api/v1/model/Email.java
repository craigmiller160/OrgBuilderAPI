package io.craigmiller160.orgbuilder.api.v1.model;

import io.craigmiller160.orgbuilder.api.v1.util.StringUtil;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Model class defining an email address.
 *
 * Created by Craig on 1/8/2016.
 */
public class Email
implements Serializable{

    private static final long serialVersionUID = 522259101203914942L;

    /**
     * Unique identifier and database primary key
     * for this Email.
     *
     * This field should NOT be assigned manually,
     * it should only be given a value consistent
     * with the keys in the database.
     */
    private Long emailId;

    /**
     * A timestamp for when the email was last
     * modified.
     *
     * This field should be assigned right before
     * each persistence operation.
     */
    private LocalDateTime lastModified;

    /*
     * The fields for the values of the
     * email address.
     */
    private EmailType emailType;
    private String emailAddress;

    /**
     * Create a new Email.
     */
    public Email(){}

    /**
     * Create a new Email with its fields defined.
     *
     * @param emailType the type of email address.
     * @param emailAddress the email address.
     */
    public Email(EmailType emailType, String emailAddress){
        this.emailType = emailType;
        this.emailAddress = emailAddress;
    }

    /**
     * Get the unique identifier for this
     * email address.
     *
     * @return the unique ID for this email.
     */
    public Long getEmailId() {
        return emailId;
    }

    /**
     * Set the unique identifier for this
     * email address.
     *
     * @param emailId the unique ID for this email.
     */
    public void setEmailId(Long emailId) {
        this.emailId = emailId;
    }

    /**
     * Get the timestamp of when this email
     * was last modified.
     *
     * @return the last modified timestamp.
     */
    public LocalDateTime getLastModified() {
        return lastModified;
    }

    /**
     * Set the timestamp of when this email
     * was last modified.
     *
     * @param lastModified the last modified timestamp.
     */
    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    /**
     * Get the type of email address.
     *
     * @return the type of email address.
     */
    public EmailType getEmailType() {
        return emailType;
    }

    /**
     * Set the type of email address.
     *
     * @param emailType the type of email address.
     */
    public void setEmailType(EmailType emailType) {
        this.emailType = emailType;
    }

    /**
     * Get the email address.
     *
     * @return the email address.
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Set the email address.
     *
     * @param emailAddress the email address.
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Email email = (Email) o;

        //noinspection SimplifiableIfStatement
        if (emailType != email.emailType) return false;
        return !(emailAddress != null ? !emailAddress.equals(email.emailAddress) : email.emailAddress != null);

    }

    @Override
    public int hashCode() {
        int result = emailType != null ? emailType.hashCode() : 0;
        result = 31 * result + (emailAddress != null ? emailAddress.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        if(StringUtil.ensureStringExists(emailAddress)){
            return emailAddress;
        }
        return null; //TODO consider a better final output, for this and the other models
    }

    /**
     * The types of email addresses
     * supported by this model.
     */
    public enum EmailType{
        PERSONAL,
        WORK,
        OTHER
    }
}
