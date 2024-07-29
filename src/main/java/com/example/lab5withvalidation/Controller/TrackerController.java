package com.example.lab5withvalidation.Controller;

import com.example.lab5withvalidation.APIResponse.API;
import com.example.lab5withvalidation.Model.Tracker;
import jakarta.validation.Valid;
import lombok.Data;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Data
@RestController
@RequestMapping("/api/v1/tracker")
public class TrackerController {
    ArrayList<Tracker> trackers = new ArrayList<Tracker>();
@GetMapping("/get")
    public ResponseEntity getTrackers() {
    return ResponseEntity.status(200).body(trackers);
@PostMapping("/add")
    public ResponseEntity addTracker(@Valid @RequestBody Tracker tracker, Errors errors) {
    if (errors.hasErrors()) {
        String message = errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
        trackers.add(tracker);
        return ResponseEntity.status(200).body(new API("Successfully Added "));
}
@PutMapping("/update/{index}")
public ResponseEntity updateTracker(@PathVariable int index,@Valid @RequestBody Tracker tracker, Errors errors) {
    if (errors.hasErrors()) {
        String message = errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
    trackers.set(index, tracker);
    return ResponseEntity.status(200).body(new API("Successfully Updated "));
}

    @DeleteMapping("/delete/{index}")
    public ResponseEntity deleteTracker(@PathVariable int index) {
    trackers.remove(index);
    return ResponseEntity.status(200).body(new API("Successfully Deleted "));
    }

    @PutMapping("/change/{index}")
    public ResponseEntity setTracker(@PathVariable int index) {
        if(trackers.get(index).getStatus().equalsIgnoreCase("Not Started")){
            trackers.get(index).setStatus("In Progress");
        }else if(trackers.get(index).getStatus().equalsIgnoreCase("In Progress")) {
            trackers.get(index).setStatus("Completed");
        }else if(trackers.get(index).getStatus().equalsIgnoreCase("Completed")) {
            return ResponseEntity.status(200).body(new API("Already Completed "));

        }return ResponseEntity.status(200).body(new API ("Successfully Updated "));}

@GetMapping("/search/{str}")
public ResponseEntity searchTracker(@PathVariable String str) {
    for (Tracker tracker : trackers) {
        if(tracker.getTitle().equalsIgnoreCase(str)) {
            return ResponseEntity.status(200).body(tracker);
        }
    }return ResponseEntity.status(400).body(new API("User not found"));

}
    @GetMapping("/display/{company}")
    public ResponseEntity displayTracker(@PathVariable String company) {
        ArrayList<Tracker> trackerrs = new ArrayList<>();
    for (Tracker tracker : trackers) {
        if(tracker.getCompanyName().equalsIgnoreCase(company)){
            trackerrs.add(tracker);
           // return ResponseEntity.status(200).body( tracker);
    }
    }return ResponseEntity.status(200).body(trackerrs);
}}





