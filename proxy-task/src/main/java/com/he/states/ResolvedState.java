package com.he.states;

import com.he.tasks.Task;
import com.he.tasks.TaskImpl;

public class ResolvedState extends State {

    public ResolvedState(Task taskImpl) {
        super(taskImpl);
    }

    @Override
    public void up(String... args) {
        log("up");
        taskImpl.setState(new TestingState(taskImpl));
        taskImpl.setTesterId(Integer.parseInt(args[0]));
    }

    @Override
    public void down(String... args) {
        log("down");
        taskImpl.setState(new InProgressState(taskImpl));
    }

}
