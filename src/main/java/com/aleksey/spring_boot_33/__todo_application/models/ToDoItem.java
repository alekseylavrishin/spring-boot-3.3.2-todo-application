package com.aleksey.spring_boot_33.__todo_application.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Entity
@Table(name = "todo_items")
public class ToDoItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String description;

    private Boolean isComplete;

    private Instant createdAt;

    private Instant updatedAt;

    @Override
    public String toString() {
        return String.format("ToDoItem{id=%d, description='%s', isComplete='%s', createdAt='%s', updatedAt='%s'}"
            , id, description, isComplete, createdAt, updatedAt);
    }

    /**
     * Converts an instant into mm.dd.yyyy format
     * @param instant The instant being converted to human-readable format
     * @return A human-readable representation of the instant in mm.dd.yyyy format
     */
    public String formatDate(Instant instant) {
        final String PATTERN_FORMAT = "MM.dd.yyyy";

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(PATTERN_FORMAT)
                .withZone(ZoneId.systemDefault());

        String formattedInstant = formatter.format(instant);
        return formattedInstant;
    }


}
