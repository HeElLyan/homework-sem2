package com.he.states;

import com.he.tasks.Task;

public class AssignState extends State {

    public AssignState(Task taskImpl) {
        super(taskImpl);
    }

    public void up(String... args) {
        log("up");
        taskImpl.setState(new InProgressState(taskImpl));
    }

    public void down(String... args) {
        log("down");
        taskImpl.setState(new OpenState(taskImpl));
        taskImpl.setDeveloperId(null);
    }

}
