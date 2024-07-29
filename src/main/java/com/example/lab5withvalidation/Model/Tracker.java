package com.example.lab5withvalidation.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tracker {

    @NotEmpty(message="ID should not be empty")
    @Size(min=3, max=15)
    private String id;
    @NotEmpty(message = "Title should not be empty")
    @Size(min=9, max=25)
    private String title;
    @NotEmpty(message="Description should not be empty")
    @Size(min=16)
    private String description;
    @NotEmpty(message="Status should not be empty")
    @Pattern(regexp="^(Not Started|In Progress|Completed)$",message = "You have only 3 options(Not Started,In Progress,Completed)")
    private String status;
    @NotEmpty(message= "Company name should not be empty")
    @Size(min=6, max=15)
    private String companyName;

}
