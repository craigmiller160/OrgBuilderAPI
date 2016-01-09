package io.craigmiller160.orgbuilder.api.v1.model;

/**
 * An address that is owned by a person. This
 * subclass contains a reference to the
 * Person object that owns the address,
 * to facilitate a foreign key relationship
 * during persistence.
 *
 * Created by Craig on 1/9/2016.
 */
public class PersonAddress extends Address {

    private static final long serialVersionUID = -5825958191570732082L;

    /**
     * The owner of this address.
     */
    private Person owner;

    /**
     * Get the person who owns this address.
     *
     * @return the person who owns this address.
     */
    public Person getOwner() {
        return owner;
    }

    /**
     * Set the person who owns this address.
     *
     * @param owner the person who owns this address.
     */
    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
