package com.example.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;

class TaskTimerResumeTest {
  @Test
  void resumeSetsRunningRecordsStartTimeAndPreservesDuration() {
    AtomicReference<Instant> now = new AtomicReference<>(Instant.parse("2026-01-18T10:00:00Z"));
    TaskTimer timer = new TaskTimer(now::get);
    timer.start();

    now.set(Instant.parse("2026-01-18T10:05:00Z"));
    timer.pause();
    long accumulated = timer.getAccumulatedDuration();

    now.set(Instant.parse("2026-01-18T10:06:00Z"));
    timer.resume();

    assertEquals(TaskTimer.State.RUNNING, timer.getState());
    assertNotNull(timer.getStartTime());
    assertEquals(accumulated, timer.getAccumulatedDuration());
  }
}
