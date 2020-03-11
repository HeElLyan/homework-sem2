package com.he.states;

import com.he.tasks.Task;
import com.he.tasks.TaskImpl;

public class DraftState extends State {

    public DraftState(Task taskImpl) {
        super(taskImpl);
    }

    public void up(String... args) {
        log("up");
        taskImpl.setState(new OpenState(taskImpl));
    }

    public void down(String... args) {
        log("down");
    }

}
