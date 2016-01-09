package io.craigmiller160.orgbuilder.api.v1.model;

import io.craigmiller160.orgbuilder.api.v1.util.StringUtil;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

/**
 * Model class that defines a person.
 * This is the base model of the people
 * section of the API.
 *
 * Created by Craig on 1/7/2016.
 */
public class Person {

    //TODO need to add fields for addresses, phones, and emails

    /**
     * Unique identifier and database primary key
     * for this Person.
     *
     * This field should NOT be assigned manually,
     * it should only be given a value consistent
     * with the keys in the database.
     */
    private Long personId;

    /**
     * A timestamp for when the person was last
     * modified.
     *
     * This field should be assigned right before
     * each persistence operation.
     */
    private LocalDateTime lastModified;

    /*
     * The fields for the values of the
     * person.
     */
    private String prefix;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private LocalDate birthDate;
    private Gender gender;

    /**
     * Create a new person.
     */
    public Person(){}

    /**
     * Create a person with defined fields.
     *
     * @param firstName the person's first name.
     * @param lastName the person's last name.
     * @param birthDate the person's birth date.
     * @param gender the person's gender.
     */
    public Person(String firstName, String lastName,
                  LocalDate birthDate, Gender gender){
        this(null, firstName, null, lastName, null, birthDate, gender);
    }

    /**
     * Create a person with defined fields, including middle name.
     *
     * @param firstName the person's first name.
     * @param middleName the person's middle name.
     * @param lastName the person's last name.
     * @param birthDate the person's birth date.
     * @param gender the person's gender.
     */
    public Person(String firstName, String middleName, String lastName,
                  LocalDate birthDate, Gender gender){
        this(null, firstName, middleName, lastName, null, birthDate, gender);
    }

    /**
     * Create a person with defined fields, including middle name
     * and prefix/suffix.
     *
     * @param prefix the person's name prefix (Mr/Mrs/etc).
     * @param firstName the person's first name.
     * @param middleName the person's middle name.
     * @param lastName the person's last name.
     * @param suffix the person's name suffix (Jr/Sr/etc).
     * @param birthDate the person's birth date.
     * @param gender the person's gender.
     */
    public Person(String prefix, String firstName, String middleName,
                  String lastName, String suffix, LocalDate birthDate, Gender gender){
        this.prefix = prefix;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    /**
     * Get the unique identifier of this person.
     *
     * @return the unique ID of this person.
     */
    public Long getPersonId() {
        return personId;
    }

    /**
     * Set the unique identifier of this person.
     *
     * @param personId the unique ID of this person.
     */
    public void setPersonId(Long personId) {
        this.personId = personId;
    }

    /**
     * Get the timestamp of when this person
     * was last modified.
     *
     * @return the last modified timestamp.
     */
    public LocalDateTime getLastModified() {
        return lastModified;
    }

    /**
     * Set the timestamp of when this person
     * was last modified.
     *
     * @param lastModified the last modified timestamp.
     */
    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    /**
     * Get the person's prefix.
     *
     * @return the person's prefix.
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Set the person's prefix.
     *
     * @param prefix the person's prefix.
     */
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    /**
     * Get the person's first name.
     *
     * @return the person's first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the person's first name.
     *
     * @param firstName the person's first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Get the person's middle name.
     *
     * @return the person's middle name.
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Set the person's middle name.
     *
     * @param middleName the person's middle name.
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * Get the person's last name.
     *
     * @return the person's last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the person's last name.
     *
     * @param lastName the person's last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Get the person's suffix (Jr/Sr/etc).
     *
     * @return the person's suffix (Jr/Sr/etc).
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     * Set the person's suffix (Jr/Sr/etc).
     *
     * @param suffix the person's suffix (Jr/Sr/etc).
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     * Get the person's birth date.
     *
     * @return the person's birth date.
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Set the person's birth date.
     *
     * @param birthDate the person's birth date.
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Get the person's age in years,
     * based on their birth date. If
     * the birth date is not set, this
     * method will return 0.
     *
     * @return the person's age in years.
     */
    public int getAge(){
        if(birthDate != null){
            return Period.between(birthDate, LocalDate.now()).getYears();
        }
        return 0;
    }

    /**
     * Get the person's gender.
     *
     * @return the person's gender.
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Set the person's gender.
     *
     * @param gender the person's gender.
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (prefix != null ? !prefix.equals(person.prefix) : person.prefix != null) return false;
        if (firstName != null ? !firstName.equals(person.firstName) : person.firstName != null) return false;
        if (middleName != null ? !middleName.equals(person.middleName) : person.middleName != null) return false;
        if (lastName != null ? !lastName.equals(person.lastName) : person.lastName != null) return false;
        if (suffix != null ? !suffix.equals(person.suffix) : person.suffix != null) return false;
        //noinspection SimplifiableIfStatement
        if (birthDate != null ? !birthDate.equals(person.birthDate) : person.birthDate != null) return false;
        return gender == person.gender;

    }

    @Override
    public int hashCode() {
        int result = prefix != null ? prefix.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (middleName != null ? middleName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (suffix != null ? suffix.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        return result;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        if(StringUtil.ensureStringExists(firstName)){
            builder.append(firstName);
        }

        if(StringUtil.ensureStringExists(middleName)){
            StringUtil.ensureEndsWithSpace(builder);
            builder.append(middleName);
        }

        if(StringUtil.ensureStringExists(lastName)){
            StringUtil.ensureEndsWithSpace(builder);
            builder.append(lastName);
        }

        return builder.toString();
    }

    /**
     * Enumeration of the options
     * for Gender.
     */
    public enum Gender{
        MALE,
        FEMALE,
        TRANSGENDER,
        OTHER
    }
}
