package com.lloyds.talking.clock.service;

public interface TalkingClockService {
    /**
     * Get the time in human friendly format.
     * @param time clock time
     * @return human friendly time
     */
    String getHumanFriendlyTime(String time);
}
