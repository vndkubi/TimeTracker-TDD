package com.example.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;

class TaskTimerPauseTest {
  @Test
  void pauseCalculatesDurationSetsPausedAndClearsStartTime() {
    AtomicReference<Instant> now = new AtomicReference<>(Instant.parse("2026-01-18T10:00:00Z"));
    TaskTimer timer = new TaskTimer(now::get);
    timer.start();

    now.set(Instant.parse("2026-01-18T10:10:00Z"));
    timer.pause();

    assertEquals(TaskTimer.State.PAUSED, timer.getState());
    assertNull(timer.getStartTime());
    assertEquals(600_000L, timer.getAccumulatedDuration());
  }
}
