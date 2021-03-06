package io.craigmiller160.orgbuilder.api.v1.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * An email address that is owned by a person. This
 * subclass contains a reference to the
 * Person object that owns the address,
 * to facilitate a foreign key relationship
 * during persistence.
 *
 * Created by Craig on 1/9/2016.
 */
@Entity
@Table(name = "people_emails")
public class PersonEmail
        extends Email{

    private static final long serialVersionUID = 7202296253006942018L;

    /**
     * The owner of this email.
     */
    @ManyToOne
    @JoinColumn (name = "person_id")
    private Person owner;

    /**
     * Get the person who owns this email.
     *
     * @return the person who owns this email.
     */
    public Person getOwner() {
        return owner;
    }

    /**
     * Set the person who owns this email.
     *
     * @param owner the person who owns this email.
     */
    public void setOwner(Person owner) {
        this.owner = owner;
    }

}
