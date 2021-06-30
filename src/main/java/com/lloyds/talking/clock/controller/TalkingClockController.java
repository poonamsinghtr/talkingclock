package com.lloyds.talking.clock.controller;

import com.lloyds.talking.clock.exception.InvalidTimeException;
import com.lloyds.talking.clock.model.TimeResponse;
import com.lloyds.talking.clock.service.TalkingClockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TalkingClockController {

    @Autowired
    private TalkingClockService talkingClockService;

    @GetMapping(value = "/clock")
    @ResponseBody
    public ResponseEntity<Object> getTimeInWords(@RequestParam(required = false) String time)  {
        ResponseEntity<Object> responseResponseEntity;
        try {
            responseResponseEntity = new ResponseEntity<>(new TimeResponse(talkingClockService.getHumanFriendlyTime(time)), HttpStatus.OK);
        } catch (InvalidTimeException exp) {
            responseResponseEntity = new ResponseEntity<>(exp.getMessage(), HttpStatus.BAD_REQUEST);
        }
      return responseResponseEntity;
    }
}
