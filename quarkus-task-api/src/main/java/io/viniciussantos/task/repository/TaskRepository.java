package io.viniciussantos.task.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.viniciussantos.task.model.Task;

import javax.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class TaskRepository implements PanacheRepository<Task> {
    // Custom query methods if needed


}
