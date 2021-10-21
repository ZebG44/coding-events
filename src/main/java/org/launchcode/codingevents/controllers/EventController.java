package org.launchcode.codingevents.controllers;


import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.EventType;
import org.launchcode.codingevents.models.Events;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")

public class EventController {

    //private static List<Events> events = new ArrayList<>();

    @GetMapping
    public String displayAllEvents(Model model) {
//        List<String> events = new ArrayList<>();
//        events.add("Code Revolution");
//        events.add("Vets in Coding");
//        events.add("Hackerthon");
//        model.addAttribute("events", events);
        model.addAttribute("title", "All Events");
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    //lives at /events/create
    @GetMapping("create")
    public String renderCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Events());
        model.addAttribute("types", EventType.values());
        return "events/create";
    }

    //lives at /events/create
//    @PostMapping("create")
//    public String createEvent(@RequestParam String eventName, @RequestParam String eventDescription){
//        EventData.add(new Events(eventName, eventDescription));
//        return "redirect:";
//    }

    //lives at /events/create
    @PostMapping("create")
    public String createEvent(@ModelAttribute @Valid Events newEvent, Errors errors, Model model){

        if (errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            //model.addAttribute("errorMsg", "Bad Data!");
            return "events/create";
        }
        EventData.add(newEvent);
        return "redirect:";
    }

    @GetMapping("delete")
    public String displayDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds){
        if (eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:";
    }

    @GetMapping("edit/{eventId}")
    public String displayEditForm(Model model, @PathVariable int eventId) {
        Events eventToEdit = EventData.getById(eventId);
        model.addAttribute("event", eventToEdit);
        String title = "Edit Event " + eventToEdit.getName() + " (id=" + eventToEdit.getId() + ")";
        model.addAttribute("title", title );
        return "events/edit";
    }

    @PostMapping("edit")
    public String processEditForm(int eventId, String name, String description) {
        Events eventToEdit = EventData.getById(eventId);
        eventToEdit.setName(name);
        eventToEdit.setDescription(description);
        return "redirect:";
    }

}
