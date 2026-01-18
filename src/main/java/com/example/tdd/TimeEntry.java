package com.example.tdd;

import java.time.Instant;

public class TimeEntry {
  private final Instant startTime;
  private final Instant endTime;
  private final long accumulatedDuration;

  public TimeEntry(Instant startTime, Instant endTime, long accumulatedDuration) {
    this.startTime = startTime;
    this.endTime = endTime;
    this.accumulatedDuration = accumulatedDuration;
  }

  public Instant getStartTime() {
    return startTime;
  }

  public Instant getEndTime() {
    return endTime;
  }

  public long getAccumulatedDuration() {
    return accumulatedDuration;
  }
}
