package com.lloyds.talking.clock;

import com.lloyds.talking.clock.service.TalkingClockService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnNotWebApplication;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnNotWebApplication
public class TalkingClockConsoleApplication implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(TalkingClockConsoleApplication.class);

    @Autowired
    private TalkingClockService talkingClockService;

    @Override
    public void run(String... args) {
        LOGGER.info("---------Console Application---------");
        if(args.length > 1) {
            LOGGER.error("Please provide the valid number of inputs");
            System.exit(1);
        }
        String inputTime = args.length == 0 ? "" : args[0];
        LOGGER.info(talkingClockService.getHumanFriendlyTime(inputTime));
    }
}
