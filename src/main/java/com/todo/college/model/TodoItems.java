package com.todo.college.model;


public class TodoItems {

    private Long id;

    private String topic;

    private String description;

    private Long userId;

    public TodoItems() {
    }

    public TodoItems(Long id,
                     String topic,
                     String description,
                     Long userId) {

        this.id = id;
        this.topic = topic;
        this.description = description;
        this.userId = userId;
    }

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
