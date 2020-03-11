package com.he.states;

import com.he.tasks.Task;

public class OpenState extends State {

    public OpenState(Task taskImpl) {
        super(taskImpl);
    }

    public void up(String... args) {
        log("up");
        taskImpl.setState(new AssignState(taskImpl));
        taskImpl.setDeveloperId(Integer.parseInt(args[0]));
    }

    public void down(String... args) {
        log("down");
        taskImpl.setState(new BacklogState(taskImpl));
    }

}
