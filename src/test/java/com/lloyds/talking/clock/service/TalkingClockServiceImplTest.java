package com.lloyds.talking.clock.service;

import com.lloyds.talking.clock.exception.InvalidTimeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TalkingClockServiceImplTest {

    private TalkingClockService talkingClockService;

    @Test
    public void testTimeWhereMinIsLessThan30InEnglish(){
        String expected = "Nineteen past Twelve";
        talkingClockService = new TalkingClockServiceImpl();

        //when
        String humanFriendlyTime = talkingClockService.getHumanFriendlyTime("12:19");

        //then
        assertEquals(expected, humanFriendlyTime);
    }

    @Test
    public void testTimeWhereMinIsGreaterThan30InEnglish(){
        String expected = "Nineteen to One";
        talkingClockService = new TalkingClockServiceImpl();

        //when
        String humanFriendlyTime = talkingClockService.getHumanFriendlyTime("12:41");

        //then
        assertEquals(expected, humanFriendlyTime);
    }

    @Test
    public void testMidNightTimeInEnglish(){
        String expected = "Twelve o' clock";
        talkingClockService = new TalkingClockServiceImpl();

        //when
        String humanFriendlyTime = talkingClockService.getHumanFriendlyTime("00:00");

        //then
        assertEquals(expected, humanFriendlyTime);
    }

    @Test
    public void testMidNightPass20MinsTimeInEnglish(){
        String expected = "Twenty past Twelve";
        talkingClockService = new TalkingClockServiceImpl();

        //when
        String humanFriendlyTime = talkingClockService.getHumanFriendlyTime("00:20");

        //then
        assertEquals(expected, humanFriendlyTime);
    }

    @Test
    public void testMidDayTimeInEnglish(){
        String expected = "Twelve o' clock";
        talkingClockService = new TalkingClockServiceImpl();

        //when
        String humanFriendlyTime = talkingClockService.getHumanFriendlyTime("12:00");

        //then
        assertEquals(expected, humanFriendlyTime);
    }

    @Test
    public void testQuarterToFiveMorningInEnglish(){
        String expected = "Quarter to Five";
        talkingClockService = new TalkingClockServiceImpl();

        //when
        String humanFriendlyTime = talkingClockService.getHumanFriendlyTime("04:45");

        //then
        assertEquals(expected, humanFriendlyTime);
    }

    @Test
    public void testQuarterPastFiveMorningInEnglish(){
        String expected = "Quarter past Five";
        talkingClockService = new TalkingClockServiceImpl();

        //when
        String humanFriendlyTime = talkingClockService.getHumanFriendlyTime("05:15");

        //then
        assertEquals(expected, humanFriendlyTime);
    }

    @Test
    public void testHalfPastFiveMorningInEnglish(){
        String expected = "Half past Five";
        talkingClockService = new TalkingClockServiceImpl();

        //when
        String humanFriendlyTime = talkingClockService.getHumanFriendlyTime("05:30");

        //then
        assertEquals(expected, humanFriendlyTime);
    }

    @Test
    public void testTwoPMTimeInEnglish(){
        String expected = "Twenty five to Three";
        talkingClockService = new TalkingClockServiceImpl();

        //when
        String humanFriendlyTime = talkingClockService.getHumanFriendlyTime("14:35");

        //then
        assertEquals(expected, humanFriendlyTime);
    }

    @Test
    public void exceptionWhenIntIsNotPassAsTime(){
        talkingClockService = new TalkingClockServiceImpl();

        InvalidTimeException invalidTimeException = assertThrows(InvalidTimeException.class, () -> talkingClockService.getHumanFriendlyTime("aa:bb"));
        assertEquals("Input Time should be in number format", invalidTimeException.getMessage());
    }

    @Test
    public void exceptionWhenInvalidTime(){
        talkingClockService = new TalkingClockServiceImpl();

        InvalidTimeException invalidTimeException = assertThrows(InvalidTimeException.class, () -> talkingClockService.getHumanFriendlyTime("89:23"));
        assertEquals("Time should be in range from hr(0 - 24) and min(0 -59)", invalidTimeException.getMessage());
    }
}