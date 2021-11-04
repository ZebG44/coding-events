//package org.launchcode.codingevents.data;
//
//import org.launchcode.codingevents.models.Events;
//
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.Map;
//
//public class EventData {
//
//    //need a place to put events
//    private static final Map<Integer, Events> events = new HashMap<>();
//
//    //get all events
//    public static Collection<Events> getAll() {
//        return events.values();
//    }
//
//    //get a single event
//    public static Events getById(int id) {
//        return events.get(id);
//    }
//
//    //add an event
//    public static void add(Events event) {
//        events.put(event.getId(), event);
//    }
//
//    //remove an event
//    public static void remove(int id) {
//        events.remove(id);
//    }
//}
