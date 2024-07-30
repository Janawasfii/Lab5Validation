package com.example.lab5withvalidationp2.Controller;

import com.example.lab5withvalidationp2.Model.Event;
import jakarta.validation.Valid;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/event")
public class EventController {
ArrayList<Event> events = new ArrayList<Event>();
@GetMapping("/get")
  public ResponseEntity getEvents() {
 return ResponseEntity.status(200).body(events);}

@PostMapping("/add")
public ResponseEntity addEvent(@Valid @RequestBody Event event, Errors errors) {
    if (errors.hasErrors()) {
        String message = errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
    events.add(event);
    return ResponseEntity.status(200).body("Successfully added event");
}
@PutMapping("/update/{index}")
    public ResponseEntity updateEvent(@PathVariable int index, @Valid @RequestBody Event event, Errors errors) {
     if (errors.hasErrors()) {
         String message = errors.getFieldError().getDefaultMessage();
         return ResponseEntity.status(400).body(message);
     }
     events.set(index, event);
     return ResponseEntity.status(200).body("Successfully updated event");
}
@DeleteMapping("/delete/{index}")
    public ResponseEntity deleteEvent(@PathVariable int index ) {
     events.remove(index);
     return ResponseEntity.status(200).body("Successfully deleted event");
}
@PutMapping("/set/{index1}/{capacity}")
    public ResponseEntity setEvent(@PathVariable int index1, @PathVariable int capacity) {
     if(capacity > 25 ) {
         events.get(index1).setCapacity(capacity);
         return ResponseEntity.status(200).body("Successfully updated Capacity");
     }return ResponseEntity.status(400).body("Unsuccessfully updated Capacity");
}

@GetMapping("/search/{id}")
    public ResponseEntity getEvent(@PathVariable int id) {
     for (Event event : events) {
         if(event.getId().equals(id)){

         }return ResponseEntity.status(200).body(event);


     } return ResponseEntity.status(400).body("Unsuccessfully found event");
}









}



