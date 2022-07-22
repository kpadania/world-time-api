package com.intuit.worldtimeapi.utils;

import com.intuit.worldtimeapi.model.WorldTimeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Utils {
    @Autowired
    public WorldTimeResponse worldTimeResponse;

    public WorldTimeResponse getTimeandDate(String dateTime){
        String[] dateTimeArray = dateTime.split("T");
        worldTimeResponse.setDate(dateTimeArray[0]);

        String time = dateTimeArray[1].trim();
        worldTimeResponse.setTime(time.substring(0,8));

        return worldTimeResponse;
    }
}
