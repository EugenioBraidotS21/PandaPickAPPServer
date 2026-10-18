package com.pandapickapp.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeModel {
    private static final DateTimeFormatter FORMATTER = 
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public String getCurrentFormattedTime() {
        return LocalDateTime.now().format(FORMATTER);
    }
}