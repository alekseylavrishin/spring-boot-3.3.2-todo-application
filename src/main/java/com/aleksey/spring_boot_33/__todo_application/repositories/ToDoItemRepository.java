package com.aleksey.spring_boot_33.__todo_application.repositories;

import com.aleksey.spring_boot_33.__todo_application.models.ToDoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoItemRepository extends JpaRepository<ToDoItem, Long> {

}
