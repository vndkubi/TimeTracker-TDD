package com.example.tdd;

import java.time.Duration;
import java.time.Instant;
import java.util.function.Supplier;

public class TaskTimer {
  public enum State {
    RUNNING,
    PAUSED,
    STOPPED
  }

  private final Supplier<Instant> clock;
  private State state;
  private Instant startTime;
  private long accumulatedDuration;

  public TaskTimer(Supplier<Instant> clock) {
    this.clock = clock;
    this.state = State.STOPPED;
    this.accumulatedDuration = 0L;
  }

  public void start() {
    this.startTime = clock.get();
    this.state = State.RUNNING;
  }

  public void pause() {
    long elapsed = Duration.between(startTime, clock.get()).toMillis();
    this.accumulatedDuration += elapsed;
    this.startTime = null;
    this.state = State.PAUSED;
  }

  public void resume() {
    this.startTime = clock.get();
    this.state = State.RUNNING;
  }

  public State getState() {
    return state;
  }

  public Instant getStartTime() {
    return startTime;
  }

  public long getAccumulatedDuration() {
    return accumulatedDuration;
  }
}
