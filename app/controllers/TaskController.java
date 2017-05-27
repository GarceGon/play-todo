package controllers;

import models.todo.Task;
import models.todo.TaskDao;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class TaskController extends Controller {

    private TaskDao taskDao;
    private FormFactory formFactory;

    @Inject
    public TaskController(TaskDao taskDao, FormFactory formFactory) {
        this.taskDao = taskDao;
        this.formFactory = formFactory;
    }

    /**
     * Gets the list of all tasks
     * @return Json formatted list
     */
    public Result all() {
        return ok(Json.toJson(taskDao.getAll()));
    }

    /**
     * Gets the list of all to-do tasks
     * @return Json formatted list
     */
    public Result todo() {
        return ok(Json.toJson(taskDao.getTodo()));
    }

    /**
     * Gets the list of all completed tasks
     * @return Json formatted list
     */
    public Result completed() {
        return ok(Json.toJson(taskDao.getCompleted()));
    }

    /**
     * Create a new task
     * @param id Task id
     * @return Json formatted task
     */
    public Result get(int id) {
        return ok(Json.toJson(taskDao.getById(id)));
    }

    /**
     * Created a new task. Gets task data from body
     * @return
     */
    public Result put() {
        Form<Task> taskForm = formFactory.form(Task.class).bindFromRequest();

        if (taskForm.hasErrors())
            return badRequest(taskForm.errorsAsJson().toString());

        Task task = taskForm.get();

        task = taskDao.create(task);

        //Set Location header to new resource uri as REST says
        response().setHeader(LOCATION, routes.TaskController.get(task.getId()).absoluteURL(request()));
        return created(Json.toJson(task));
    }

    /**
     * Completes an existing task
     * @param id Task id
     * @return Json formatted task
     */
    public Result complete(int id) {
        Task task = taskDao.complete(id);

        if(task == null)
            return notFound("Resource not found with id: "+id);

        return ok(Json.toJson(task));
    }

    /**
     * Deletes an existing task
     * @param id Task id
     * @return no content
     */
    public Result delete(int id) {
        taskDao.delete(id);
        return noContent();
    }
}
