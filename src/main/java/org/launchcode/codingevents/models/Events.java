package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Events extends AbstractEntity {

//    @Id
//    @GeneratedValue
//    private int id;
//    private static int nextId = 1;

    @NotBlank(message = "Name is required.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String name;

    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Email is required.")
    @Email(message = "Invalid email. Try again.")
    private String contactEmail;

//    private EventType type;

    @ManyToOne
    @NotNull(message = "Category is required.")
    private EventCategory eventCategory;

    public Events(String name, String description, String contactEmail, EventCategory eventCategory /*EventType type*/) {
//        this();
        this.name = name;
        this.description = description;
        this.contactEmail = contactEmail;
        this.eventCategory = eventCategory;
//        this.type = type;
    }

    public Events() {
//        this.id = nextId;
//        nextId++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public int getId() {
//        return id;
//    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

//    public EventType getType() {
//        return type;
//    }
//
//    public void setType(EventType type) {
//        this.type = type;
//    }

    public EventCategory getEventCategory() {
        return eventCategory;
    }

    public void setEventCategory(EventCategory eventCategory) {
        this.eventCategory = eventCategory;
    }

    @Override
    public String toString() {
        return name;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Events events = (Events) o;
//        return id == events.id;
//    }

//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }
}
