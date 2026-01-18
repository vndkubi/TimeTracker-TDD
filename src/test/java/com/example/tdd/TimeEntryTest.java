package com.example.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.Instant;
import org.junit.jupiter.api.Test;

class TimeEntryTest {
  @Test
  void storesStartEndAndAccumulatedDuration() {
    Instant start = Instant.parse("2026-01-18T10:00:00Z");
    Instant end = Instant.parse("2026-01-18T10:30:00Z");
    long accumulated = 1_800_000L;

    TimeEntry entry = new TimeEntry(start, end, accumulated);

    assertNotNull(entry);
    assertEquals(start, entry.getStartTime());
    assertEquals(end, entry.getEndTime());
    assertEquals(accumulated, entry.getAccumulatedDuration());
  }
}
