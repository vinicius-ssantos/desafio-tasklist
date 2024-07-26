//package io.viniciussantos.task.model;
//
//import javax.enterprise.context.ApplicationScoped;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
//@ApplicationScoped
//public class TaskMapper {
//    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//
//    public Task toTask(TaskRequest taskRequest) {
//        Task task = new Task();
//        task.setTitle(taskRequest.getTitle());
//        task.setDescription(taskRequest.getDescription());
//        task.setStatus(taskRequest.getStatus());
//        task.setCreationDate(LocalDateTime.now());
//        return task;
//    }
//
//    public TaskResponse toTaskResponse(Task task) {
//        TaskResponse taskResponse = new TaskResponse();
//        taskResponse.setId(task.getId());
//        taskResponse.setTitle(task.getTitle());
//        taskResponse.setDescription(task.getDescription());
//        taskResponse.setStatus(task.getStatus());
//        taskResponse.setCreationDate(task.getCreationDate().format(formatter));
//        if (task.getCompletionDate() != null) {
//            taskResponse.setCompletionDate(task.getCompletionDate().format(formatter));
//        }
//        return taskResponse;
//    }
//
//    public void updateTaskFromRequest(TaskRequest taskRequest, Task task) {
//        task.setTitle(taskRequest.getTitle());
//        task.setDescription(taskRequest.getDescription());
//        task.setStatus(taskRequest.getStatus());
//        if (taskRequest.getStatus().equals(Status.COMPLETED.getStatus())) {
//            task.setCompletionDate(LocalDateTime.now());
//        }
//    }
//}