package com.he.states;

import com.he.tasks.Task;
import com.he.tasks.TaskImpl;

public class ClosedState extends State {

    public ClosedState(Task taskImpl) {
        super(taskImpl);
    }

    @Override
    public void up(String... args) {
    }

    @Override
    public void down(String... args) {
    }

}
