package ua.artcode.model;

/**
 * Created by Yaroslav on 14.12.2014.
 */
public enum TaskPriority {
    CRITICAL, HIGH, MEDIUM, LOW;

    public static TaskPriority getTaskPriority(int id) {

        TaskPriority prority = null;
        switch (id) {
            case 1: {
                prority = TaskPriority.CRITICAL;
                break;
            }
            case 2: {
                prority = TaskPriority.HIGH;
                break;
            }
            case 3: {
                prority = TaskPriority.MEDIUM;
                break;
            }
            case 4: {
                prority = TaskPriority.LOW;
                break;
            }

        }
        return prority;
    }


}
