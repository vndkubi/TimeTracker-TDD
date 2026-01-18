package com.example.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class JiraSyncServiceTest {
  @Test
  void formatWorklogConvertsMillisToJiraFormat() {
    JiraSyncService service = new JiraSyncService();

    assertEquals("2h 30m", service.formatWorklog(2 * 60 * 60 * 1000L + 30 * 60 * 1000L));
    assertEquals("45m", service.formatWorklog(45 * 60 * 1000L));
    assertEquals("1h", service.formatWorklog(60 * 60 * 1000L));
  }
}
