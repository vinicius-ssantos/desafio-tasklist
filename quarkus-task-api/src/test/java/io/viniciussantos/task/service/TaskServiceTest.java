package io.viniciussantos.task.service;

import io.viniciussantos.task.model.Status;
import io.viniciussantos.task.model.Task;
import io.viniciussantos.task.model.TaskRequest;
import io.viniciussantos.task.model.TaskResponse;
import io.viniciussantos.task.repository.TaskRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TaskServiceTest {

    @InjectMocks
    TaskService taskService;

    @Mock
    TaskRepository taskRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListAllTasks() {
        Task task1 = new Task();
        task1.setId(1L);
        task1.setTitle("Task 1");
        task1.setDescription("Description 1");
        task1.setStatus(Status.PENDING.getStatus());
        task1.setCreationDate(LocalDateTime.now());

        Task task2 = new Task();
        task2.setId(2L);
        task2.setTitle("Task 2");
        task2.setDescription("Description 2");
        task2.setStatus(Status.COMPLETED.getStatus());
        task2.setCreationDate(LocalDateTime.now());
        task2.setCompletionDate(LocalDateTime.now());

        when(taskRepository.list(anyString())).thenReturn(Arrays.asList(task1, task2));

        List<TaskResponse> tasks = taskService.listAll();

        assertEquals(2, tasks.size());
        assertEquals("Task 1", tasks.get(0).getTitle());
        assertEquals("Task 2", tasks.get(1).getTitle());

        verify(taskRepository, times(1)).list(anyString());
    }

    @Test
    @Transactional
    public void testCreateTask() {
        TaskRequest request = new TaskRequest();
        request.setTitle("New Task");
        request.setDescription("New Description");

        Task task = new Task();
        task.setId(1L);
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(Status.PENDING.getStatus());
        task.setCreationDate(LocalDateTime.now());

        doNothing().when(taskRepository).persist(any(Task.class));

        TaskResponse response = taskService.create(request);

        assertNotNull(response);
        assertEquals("New Task", response.getTitle());
        assertEquals("New Description", response.getDescription());
        assertEquals(Status.PENDING.getStatus(), response.getStatus());

        verify(taskRepository, times(1)).persist(any(Task.class));
    }

    @Test
    @Transactional
    public void testUpdateTask() {
        TaskRequest request = new TaskRequest();
        request.setTitle("Updated Task");
        request.setDescription("Updated Description");
        request.setStatus(Status.COMPLETED.getStatus());

        Task task = new Task();
        task.setId(1L);
        task.setTitle("Old Task");
        task.setDescription("Old Description");
        task.setStatus(Status.PENDING.getStatus());
        task.setCreationDate(LocalDateTime.now());

        when(taskRepository.findById(anyLong())).thenReturn(task);

        TaskResponse response = taskService.update(1L, request);

        assertNotNull(response);
        assertEquals("Updated Task", response.getTitle());
        assertEquals("Updated Description", response.getDescription());
        assertEquals(Status.COMPLETED.getStatus(), response.getStatus());

        verify(taskRepository, times(1)).findById(1L);
    }

    @Test
    @Transactional
    public void testDeleteTask() {
        doAnswer(invocation -> {
            // Simulate the delete operation
            return null;
        }).when(taskRepository).delete(eq("id"), anyLong());

        taskService.delete(1L);

        verify(taskRepository, times(1)).delete(eq("id"), anyLong());
    }
}
