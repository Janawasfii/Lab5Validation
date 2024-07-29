package com.example.lab5withvalidationp2.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Event {
    @NotEmpty(message= "ID should not be empty")
    @Size(min=3)
    private String id;
    @NotEmpty(message="Description should not be empty")
    @Size(min=16)
    private String description;
    @NotNull(message= "Capacity should not be NULL")
    @Min(26)
    @Positive(message= "Should not be a negative number")
    private int capacity;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate endDate;
}
