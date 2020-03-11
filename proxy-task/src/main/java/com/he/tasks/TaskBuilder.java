package com.he.tasks;

import com.he.states.State;

public class TaskBuilder {

    private int    id = -1;
    private int    developerId = -1;
    private int    testerId = -1;
    private String text;
    private String error;
    private State  startState;

    public TaskBuilder id(int id) {
        this.id = id;
        return this;
    }

    public TaskBuilder developerId(int developerId) {
        this.developerId = developerId;
        return this;
    }

    public TaskBuilder testerId(int testerId) {
        this.testerId = testerId;
        return this;
    }

    public TaskBuilder text(String text) {
        this.text = text;
        return this;
    }

    public TaskBuilder error(String error) {
        this.error = error;
        return this;
    }

    public TaskBuilder currentState(State currentState) {
        this.startState = currentState;
        return this;
    }

    public TaskBuilder startState(State startState) {
        this.startState = startState;
        return this;
    }

    public Task build() {
        return new TaskBuilder.TaskImpl(this);
    }

    private static class TaskImpl implements Task {
        private int id;
        private int developerId;
        private int testerId;
        private String text;
        private String error;

        private State currentState;

        public TaskImpl(TaskBuilder taskBuilder) {
            this.id = taskBuilder.id;
            this.developerId = taskBuilder.developerId;
            this.testerId = taskBuilder.testerId;
            this.text = taskBuilder.text;
            this.error = taskBuilder.error;
            this.currentState = taskBuilder.startState;
        }

        @Override
        public int getId() {
            return id;
        }

        @Override
        public void setId(int id) {
            this.id = id;
        }

        @Override
        public int getDeveloperId() {
            return developerId;
        }

        @Override
        public void setDeveloperId(Integer developerId) {
            this.developerId = developerId;
        }

        @Override
        public int getTesterId() {
            return testerId;
        }

        @Override
        public void setTesterId(Integer testerId) {
            this.testerId = testerId;
        }

        @Override
        public String getText() {
            return text;
        }

        @Override
        public void setText(String text) {
            this.text = text;
        }

        @Override
        public String getError() {
            return error;
        }

        @Override
        public void setError(String error) {
            this.error = error;
        }

        @Override
        public State getCurrentState() {
            return currentState;
        }

        @Override
        public void setCurrentState(State currentState) {
            this.currentState = currentState;
        }

        @Override
        public void up(int id) {
            this.currentState.up(String.valueOf(id));
        }

        @Override
        public void down(int id, String text) {
            this.currentState.down(String.valueOf(id), text);
        }

        @Override
        public State getState() {
            return null;
        }

        @Override
        public void setState(State state) {

        }

        @Override
        public Task copy() {
            try {
                return (Task) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new IllegalStateException(e);
            }
        }

        @Override
        public String toString() {
            return "TaskImpl{" +
                    "id=" + id +
                    ", developerId=" + developerId +
                    ", testerId=" + testerId +
                    ", text='" + text + '\'' +
                    ", error='" + error + '\'' +
                    ", currentState=" + currentState +
                    '}';
        }
    }

}
