package ua.artcode.util;

import ua.artcode.model.TaskPriority;

/**
 * Created by Yaroslav on 20.01.2015.
 */
public class TestEnum {
    public static void main(String[] args) {
        TaskPriority tp = TaskPriority.getTaskPriority(1);
        System.out.println(tp.getClass().getName() + "." + tp.name());
    }
}
