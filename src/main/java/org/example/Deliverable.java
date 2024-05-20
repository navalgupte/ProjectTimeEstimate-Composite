package org.example;

/*
    Deliverable Class - Represents a leaf/terminal node which cannot reference
    other Project items.
 */
public class Deliverable implements ProjectItem {
    private String name;
    private String description;
    private Contact owner;

    public Deliverable() {}
    public Deliverable(String newName, String newDescription, Contact newOwner) {
        name = newName;
        description = newDescription;
        owner = newOwner;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Contact getOwner() {
        return owner;
    }

    @Override
    public double getTimeRequired() {
        return 0;
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setDescription(String newDescription) {
        description = newDescription;
    }

    public void setOwner(Contact newOwner) {
        owner = newOwner;
    }
}
