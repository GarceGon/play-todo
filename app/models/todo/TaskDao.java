package models.todo;

import java.util.List;

/**
 * Created by Gonzalo on 26/05/2017.
 * Dao interface to be implemented
 */
public interface TaskDao {
    Task create(Task task);
    Task getById(int id);
    List<Task> getAll();
    List<Task> getTodo();
    List<Task> getCompleted();
    Task complete(int id);
    void delete(int id);
}
