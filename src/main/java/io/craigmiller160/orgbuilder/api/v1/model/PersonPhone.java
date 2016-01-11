package io.craigmiller160.orgbuilder.api.v1.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * A phone number that is owned by a person. This
 * subclass contains a reference to the
 * Person object that owns the address,
 * to facilitate a foreign key relationship
 * during persistence.
 *
 * Created by Craig on 1/9/2016.
 */
@Entity
@Table(name = "people_phones")
public class PersonPhone
        extends Phone{

    private static final long serialVersionUID = 5728824800208622631L;

    /**
     * The owner of this phone.
     */
    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person owner;

    /**
     * Get the person who owns this phone.
     *
     * @return the person who owns this phone.
     */
    public Person getOwner() {
        return owner;
    }

    /**
     * Set the person who owns this phone.
     *
     * @param owner the person who owns this phone.
     */
    public void setOwner(Person owner) {
        this.owner = owner;
    }

}
