package com.he.tasks;

import com.he.states.State;

public interface Task extends Copyable<Task>, Cloneable {

    int getId();

    void setId(int id);

    int getDeveloperId();

    void setDeveloperId(Integer developerId);

    int getTesterId();

    void setTesterId(Integer testerId);

    String getText();

    void setText(String text);

    String getError();

    void setError(String error);

    State getCurrentState();

    void setCurrentState(State currentState);

    void up(int id);

    void down(int id, String text);

    State getState();

    void setState(State state);

    Task copy();
}