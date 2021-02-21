package com.ticketing.implementation;

import com.ticketing.dto.TaskDTO;
import com.ticketing.entitiy.Task;
import com.ticketing.enums.Status;
import com.ticketing.mapper.TaskMapper;
import com.ticketing.repository.TaskRepository;
import com.ticketing.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    TaskRepository taskRepository;
    TaskMapper taskMapper;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public TaskDTO findById(Long id) {
        return null;
    }

    @Override
    public List<TaskDTO> listAllTasks() {
        List<Task> list = taskRepository.findAll();
        return list.stream().map(taskMapper::convertToDto).collect(Collectors.toList());
    }

    @Override
    public Task save(TaskDTO dto) {
        dto.setTaskStatus(Status.OPEN);
        dto.setAssignedDate(LocalDate.now());
        Task task = taskMapper.convertToEntity(dto);
        return taskRepository.save(task);
    }

    @Override
    public void update(TaskDTO dto) {

    }

    @Override
    public void delete(long id) {

    }
}
