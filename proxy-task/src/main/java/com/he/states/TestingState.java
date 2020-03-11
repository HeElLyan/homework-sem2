package com.he.states;

import com.he.tasks.Task;

public class TestingState extends State {

    public TestingState(Task taskImpl) {
        super(taskImpl);
    }

    public void up(String... args) {
        log("up");
        taskImpl.setState(new ClosedState(taskImpl));
        taskImpl.setDeveloperId(null);
        taskImpl.setTesterId(null);
    }

    public void down(String... args) {
        log("down");
        taskImpl.setState(new AssignState(taskImpl));
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            builder.append(args[i]);
        }
        String str = builder.toString();
        taskImpl.setError(str);
    }

}
