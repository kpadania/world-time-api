package com.intuit.worldtimeapi.service;

import com.intuit.worldtimeapi.model.WorldTimeAPIResponse;
import com.intuit.worldtimeapi.model.WorldTimeResponse;
import com.intuit.worldtimeapi.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
public class WorldTimeService {
    @Autowired
    WorldTimeAPIResponse WorldTimeAPIResponse;
    @Autowired
    WorldTimeResponse WorldTimeResponse;
    @Autowired
    Utils utils;


    public WorldTimeResponse getTimeAndDate(String area, String location){
            RestTemplate restTemplate = new RestTemplate();
            WorldTimeAPIResponse result = restTemplate.getForObject("https://worldtimeapi.org/api/timezone/"+area+"/"+location, WorldTimeAPIResponse.class);
            if(result != null){
                WorldTimeResponse response = utils.getTimeandDate(result.datetime);
                return WorldTimeResponse;
            } else {
                throw new ResponseStatusException(
                        HttpStatus.INTERNAL_SERVER_ERROR, "Server Error");
            }

    }

    public String[] getTimezoneByArea(String area) {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("https://worldtimeapi.org/api/timezone/"+area, String.class);

        return new String[]{result};
    }

    public String[] getAllTimezone() {
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject("https://worldtimeapi.org/api/timezone/", String.class);
        return new String[]{result};
    }
}
