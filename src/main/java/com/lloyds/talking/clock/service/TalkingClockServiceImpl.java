package com.lloyds.talking.clock.service;

import com.lloyds.talking.clock.HourMin;
import com.lloyds.talking.clock.exception.InvalidTimeException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TalkingClockServiceImpl implements TalkingClockService {

    public String getHumanFriendlyTime(String time) {
        int hour;
        int min;
        try {
            if (time == null || time.isEmpty()) {
                LocalDateTime now = LocalDateTime.now();
                hour = now.getHour();
                min = now.getMinute();
            } else {
                String[] split = time.split(":");
                hour = Integer.parseInt(split[0]);
                min = Integer.parseInt(split[1]);
            }
        } catch (NumberFormatException exception) {
            throw new InvalidTimeException("Input Time should be in number format");
        }
        validateTime(hour, min);
        return getTimeInEnglish(hour, min);
    }

    private void validateTime(int hr, int min) {
        if ((hr > 24 || hr < 0) || (min < 0 || min > 59)) {
            throw new InvalidTimeException("Time should be in range from hr(0 - 24) and min(0 -59)");
        }
    }

    private String getTimeInEnglish(int hour, int min) {
        String humanFriendlyTime;
        String timeInWord;

        hour = hour == 0 ? 12 : hour;
        hour = hour > 12 ? hour - 12 : hour;
        timeInWord = hour == 12 ? HourMin.convertNumToWord(1) : HourMin.convertNumToWord(hour + 1);

        if (min == 0) {
            humanFriendlyTime = HourMin.convertNumToWord(hour) + " o' clock";
        } else if (min == 15) {
            humanFriendlyTime = "Quarter past " + HourMin.convertNumToWord(hour);
        } else if (min == 30) {
            humanFriendlyTime = "Half past " + HourMin.convertNumToWord(hour);
        } else if (min == 45) {
            humanFriendlyTime = "Quarter to " + timeInWord;
        } else if (min < 30) {
            humanFriendlyTime = HourMin.convertNumToWord(min) + " past " + HourMin.convertNumToWord(hour);
        } else {
            humanFriendlyTime = HourMin.convertNumToWord(60 - min) + " to " + timeInWord;
        }
        return humanFriendlyTime;
    }
}
