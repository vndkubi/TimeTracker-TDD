package com.example.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;

class TaskTimerStopTest {
  @Test
  void stopFinalizesTotalDurationAndSetsStopped() {
    AtomicReference<Instant> now = new AtomicReference<>(Instant.parse("2026-01-18T10:00:00Z"));
    TaskTimer timer = new TaskTimer(now::get);

    timer.start();
    now.set(Instant.parse("2026-01-18T10:05:00Z"));
    timer.pause();

    now.set(Instant.parse("2026-01-18T10:06:00Z"));
    timer.resume();

    now.set(Instant.parse("2026-01-18T10:09:00Z"));
    timer.stop();

    assertEquals(TaskTimer.State.STOPPED, timer.getState());
    assertNull(timer.getStartTime());
    assertEquals(480_000L, timer.getAccumulatedDuration());
  }
}
