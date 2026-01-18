package com.example.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Instant;
import org.junit.jupiter.api.Test;

class TaskTimerTest {
  @Test
  void startInitializesTimerAndRecordsStartTime() {
    TaskTimer timer = new TaskTimer(() -> Instant.parse("2026-01-18T10:00:00Z"));

    timer.start();

    assertEquals(TaskTimer.State.RUNNING, timer.getState());
    assertNotNull(timer.getStartTime());
  }
}
