package com.he.states;

import com.he.tasks.Task;

import java.io.FileWriter;
import java.io.IOException;

public abstract class State {
    protected Task taskImpl;

    public State(Task taskImpl) {
        this.taskImpl = taskImpl;
    }

    public abstract void up(String... args);
    public abstract void down(String... args);

    protected void log(String methodName) {
        try(FileWriter writer = new FileWriter("logger.txt", false))
        {
            String text = taskImpl.getClass().getName() + " call " + methodName;
            writer.write(text);
            writer.append('\n');
            writer.append('E');

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

}
