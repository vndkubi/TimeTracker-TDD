package com.example.tdd;

public class JiraSyncService {
  public String formatWorklog(long durationMillis) {
    long totalMinutes = durationMillis / 60_000L;
    long hours = totalMinutes / 60;
    long minutes = totalMinutes % 60;

    if (hours > 0 && minutes > 0) {
      return hours + "h " + minutes + "m";
    }
    if (hours > 0) {
      return hours + "h";
    }
    return minutes + "m";
  }
}
