package com.he.tasks;

import com.he.states.State;

public class TaskImpl implements Task{
    private State state = null;
    private String text = null;
    private String error = null;
    private Integer devId = null;
    private Integer testerId = null;

    public TaskImpl() {
    }

    public TaskImpl(String text) {
        this.text = text;
    }

    public TaskImpl(State state, String text, String error, Integer devId, Integer testerId) {
        this.state = state;
        this.text = text;
        this.error = error;
        this.devId = devId;
        this.testerId = testerId;
    }

    public Task copy(){
        return new TaskImpl(this.state, this.text, this.error, this.devId, this.testerId);
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }

    @Override
    public int getDeveloperId() {
        return 0;
    }

    @Override
    public void setDeveloperId(Integer developerId) {

    }

    public int getTesterId() {
        return testerId;
    }

    @Override
    public void setTesterId(Integer testerId) {
        this.testerId = testerId;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public State getCurrentState() {
        return null;
    }


    @Override
    public void setCurrentState(State currentState) {

    }

    @Override
    public void up(int id) {

    }

    @Override
    public void down(int id, String text) {

    }

    public Integer getDevId() {
        return devId;
    }

    public void setDevId(Integer devId) {
        this.devId = devId;
    }

}
