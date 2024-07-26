package io.viniciussantos.task.api;

import io.viniciussantos.task.model.TaskRequest;
import io.viniciussantos.task.model.TaskResponse;
import io.viniciussantos.task.service.TaskService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path(TaskResource.RESOURCE_PATH)
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {

    public static final String RESOURCE_PATH = "/task";
    @Inject
    TaskService taskService;

    @GET
    public List<TaskResponse> getAllTasks() {
        return taskService.listAll();
    }

    @POST
    public TaskResponse createTask(TaskRequest taskRequest) {
        return taskService.create(taskRequest);
    }

    @PUT
    @Path("/{id}")
    public TaskResponse updateTask(@PathParam("id") Long id, TaskRequest taskRequest) {
        return taskService.update(id, taskRequest);
    }

    @DELETE
    @Path("/{id}")
    public void deleteTask(@PathParam("id") Long id) {
        taskService.delete(id);
    }
}