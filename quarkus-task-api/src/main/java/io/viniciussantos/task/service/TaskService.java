package io.viniciussantos.task.service;

import io.viniciussantos.task.model.Status;
import io.viniciussantos.task.model.Task;
import io.viniciussantos.task.model.TaskRequest;
import io.viniciussantos.task.model.TaskResponse;
import io.viniciussantos.task.repository.TaskRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class TaskService {
    @Inject
    TaskRepository taskRepository;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

//    public List<TaskResponse> listAll() {
//        return taskRepository.list("order by creationDate desc")
//                .stream()
//                .map(taskMapper::toTaskResponse)
//                .collect(Collectors.toList());
//
//    }

    public List<TaskResponse> listAll() {
      var tasklist =  taskRepository.list("order by creationDate desc")
                .stream()
                .map(task -> {
                    TaskResponse response = new TaskResponse();
                    response.setId(task.getId());
                    response.setTitle(task.getTitle());
                    response.setDescription(task.getDescription());
                    response.setStatus(task.getStatus());
                    response.setCreationDate(formatter.format(task.getCreationDate()))  ;
                    if (task.getCompletionDate() != null) {
                        response.setCompletionDate(task.getCompletionDate().format(formatter));
                    }
                    return response;
                })
                .collect(Collectors.toList());
        System.out.println(tasklist);
        return tasklist;
    }

//    @Transactional
//    public TaskResponse create(TaskRequest taskRequest) {
//        Task task = taskMapper.toTask(taskRequest);
//        task.setStatus(Status.PENDING.getStatus());
//        taskRepository.persist(task);
//        return taskMapper.toTaskResponse(task);
//    }

    @Transactional
    public TaskResponse create(TaskRequest taskRequest) {
        Task task = new Task();
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        task.setStatus(Status.PENDING.getStatus());
        task.setCreationDate(LocalDateTime.now());
        taskRepository.persist(task);

        TaskResponse response = new TaskResponse();
        response.setId(task.getId());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setStatus(task.getStatus());
        response.setCreationDate(task.getCreationDate().format(formatter));
        if (task.getCompletionDate() != null) {
            response.setCompletionDate(task.getCompletionDate().format(formatter));
        }
        return response;
    }

//    @Transactional
//    public TaskResponse update(Long id, TaskRequest taskRequest) {
//        Task taskDB = taskRepository.findById(id);
//        if (taskDB != null) {
//            taskMapper.updateTaskFromRequest(taskRequest, taskDB);
//        }
//        return taskMapper.toTaskResponse(taskDB);
//    }

    @Transactional
    public TaskResponse update(Long id, TaskRequest taskRequest) {
        Task taskDB = taskRepository.findById(id);
        if (taskDB != null) {
            taskDB.setTitle(taskRequest.getTitle());
            taskDB.setDescription(taskRequest.getDescription());
            taskDB.setStatus(taskRequest.getStatus());
            if (taskRequest.getStatus().equals(Status.COMPLETED.getStatus())) {
                taskDB.setCompletionDate(LocalDateTime.now());
            }
        }

        TaskResponse response = new TaskResponse();
        response.setId(taskDB.getId());
        response.setTitle(taskDB.getTitle());
        response.setDescription(taskDB.getDescription());
        response.setStatus(taskDB.getStatus());
        response.setCreationDate(taskDB.getCreationDate().format(formatter));
        if (taskDB.getCompletionDate() != null) {
            response.setCompletionDate(taskDB.getCompletionDate().format(formatter));
        }
        return response;
    }

    @Transactional
    public void delete(Long id) {
        taskRepository.delete("id", id);
    }
}