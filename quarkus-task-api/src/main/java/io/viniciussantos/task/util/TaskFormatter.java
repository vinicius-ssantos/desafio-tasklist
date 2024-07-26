package io.viniciussantos.task.util;

import io.viniciussantos.task.model.Task;
import io.viniciussantos.task.model.TaskResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class TaskFormatter {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static TaskResponse format(Task task) {
        TaskResponse response = new TaskResponse();
        response.setId(task.getId());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setStatus(task.getStatus());
        response.setCreationDate(formatDate(task.getCreationDate()));
        response.setCompletionDate(formatDate(task.getCompletionDate()));
        return response;
    }

    private static String formatDate(LocalDateTime dateTime) {
        return Objects.requireNonNull(dateTime, "temporal").format(formatter);
    }
}