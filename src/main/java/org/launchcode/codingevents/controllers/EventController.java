package org.launchcode.codingevents.controllers;


import org.launchcode.codingevents.data.EventData;
import org.launchcode.codingevents.models.Events;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String renderCreateEventForm() {
        return "events/create";
    }

    //lives at /events/create
//    @PostMapping("create")
//    public String createEvent(@RequestParam String eventName, @RequestParam String eventDescription, @RequestParam String contactEmail){
//        EventData.add(new Events(eventName, eventDescription, contactEmail));
//        return "redirect:";
//    }

    //lives at /events/create
    @PostMapping("create")
    public String processCreateEventForm(@ModelAttribute Events newEvent){
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


}
