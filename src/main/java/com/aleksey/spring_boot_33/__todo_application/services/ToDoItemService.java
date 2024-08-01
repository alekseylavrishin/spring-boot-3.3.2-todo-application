package com.aleksey.spring_boot_33.__todo_application.services;

import com.aleksey.spring_boot_33.__todo_application.models.ToDoItem;
import com.aleksey.spring_boot_33.__todo_application.repositories.ToDoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.Instant;
import java.util.Optional;

@Service
public class ToDoItemService {

    @Autowired
    private ToDoItemRepository ToDoItemRepository;

    /**
     * Returns all ToDoItems in the repository
     * @return all ToDoItems
     */
    public Iterable<ToDoItem> getAll() {
        return ToDoItemRepository.findAll();
    }

    /**
     * Finds and returns the ToDoItem associated with the provided id
     * @param id The id of the ToDoItem you want to return
     * @return The ToDoItem corresponding to the provided id
     */
    public Optional<ToDoItem> getById(Long id) {
        return ToDoItemRepository.findById(id);
    }

    /**
     * Save a provided ToDoItem to the repository
     * @param item The item you want saved
     * @return The saved item
     */
    public ToDoItem save(ToDoItem item) {
        if (item.getId() == null) {
            item.setCreatedAt(Instant.now());
        }
        item.setUpdatedAt(Instant.now());
        return ToDoItemRepository.save(item);
    }

    /**
     * Deletes a specific item from the ToDoItemRepository
     * @param item The item you want to be deleted
     */
    public void delete(ToDoItem item) {
        ToDoItemRepository.delete(item);
    }
}
