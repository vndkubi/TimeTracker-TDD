package com.example.tdd;

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

  public TaskTimer(Supplier<Instant> clock) {
    this.clock = clock;
    this.state = State.STOPPED;
  }

  public void start() {
    this.startTime = clock.get();
    this.state = State.RUNNING;
  }

  public State getState() {
    return state;
  }

  public Instant getStartTime() {
    return startTime;
  }
}
