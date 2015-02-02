package ua.artcode.model;

/**
 * Created by Yaroslav on 14.12.2014.
 */
public enum TaskState {

    CREATED, PROSED, CLOSE, REOPENING;

    public static TaskState getTaskState(int id) {
        TaskState state = null;
        switch (id) {
            case 1: {
                state = TaskState.CREATED;
                break;
            }
            case 2: {
                state = TaskState.PROSED;
                break;
            }
            case 3: {
                state = TaskState.CLOSE;
                break;
            }
            case 4: {
                state = TaskState.REOPENING;
                break;
            }

        }
        return state;
    }
}

