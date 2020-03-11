package com.he.tasks;

public interface TaskLogger extends TaskProxy{
    void flush();
    void close();
}
