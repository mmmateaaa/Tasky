package hr.ferit.matea.tasky.ui;

import hr.ferit.matea.tasky.model.ToDo;

/**
 * Created by Matea on 4/18/2018.
 */

public interface ToDoClickCallback {
    boolean onLongClick(ToDo toDo);
}
