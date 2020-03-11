package com.he.proxy;

import com.he.tasks.Task;
import com.he.tasks.TaskLogger;

import java.io.Writer;

public class TaskProxyFactory {

    public TaskLogger newLoggerProxyInstance(Task task, Writer writer) {
        return new TaskLoggerProxyImpl(task, writer);
    }
}
