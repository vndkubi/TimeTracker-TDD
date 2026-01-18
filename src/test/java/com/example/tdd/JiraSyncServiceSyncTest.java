package com.example.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class JiraSyncServiceSyncTest {
  @Test
  void syncAcceptsCorrectPayload() {
    JiraSyncService service = new JiraSyncService();

    WorklogPayload payload = service.sync("TASK-123", "2h 30m", "Worked on feature");

    assertNotNull(payload);
    assertEquals("TASK-123", payload.getTaskId());
    assertEquals("2h 30m", payload.getTimeSpent());
    assertEquals("Worked on feature", payload.getComment());
  }
}
