package com.example.tdd;

public class WorklogPayload {
  private final String taskId;
  private final String timeSpent;
  private final String comment;

  public WorklogPayload(String taskId, String timeSpent, String comment) {
    this.taskId = taskId;
    this.timeSpent = timeSpent;
    this.comment = comment;
  }

  public String getTaskId() {
    return taskId;
  }

  public String getTimeSpent() {
    return timeSpent;
  }

  public String getComment() {
    return comment;
  }
}
