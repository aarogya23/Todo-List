package com.todo.college.model;

public class todoIteams {

    private Long id;
    private String topic;
    private String description;

    private todoIteams(){}

    private todoIteams(Long id, String topic, String description) {
        this.id = id;
        this.topic = topic;
        this.description = description;
    }

    private long counter;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public long getCounter() {
        return counter;
    }
    public void setCounter(long counter) {
        this.counter = counter;
    }
}
