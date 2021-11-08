package org.launchcode.codingevents.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EventCategory extends AbstractEntity{

//    @Id
//    @GeneratedValue
//    private int id;

    @OneToMany(mappedBy = "eventCategory")
    private final List<Events> events = new ArrayList<>();

    private String name;

    public EventCategory(String name) {
        this.name = name;
    }

    public EventCategory () {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getId() {
//        return id;
//    }

    public List<Events> getEvents() {
        return events;
    }

    @Override
    public String toString() {
        return name;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        EventCategory that = (EventCategory) o;
//        return id == that.id;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id);
//    }

}
