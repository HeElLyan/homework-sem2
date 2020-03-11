package com.he.states;

import com.he.tasks.Task;

public class InProgressState extends State {

    public InProgressState(Task taskImpl) {
        super(taskImpl);
    }

    public void up(String... args) {
        log("up");
        taskImpl.setState(new ResolvedState(taskImpl));
    }

    public void down(String... args) {
        log("down");
        taskImpl.setState(new AssignState(taskImpl));
    }


}
