package com.ticketing.repository;

import com.ticketing.entitiy.Project;
import com.ticketing.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findByProjectCode(String code);

    List<Project> findAllByAssignedManager(User manager);
}
