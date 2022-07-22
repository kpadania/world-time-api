package com.intuit.worldtimeapi.controller;

import com.intuit.worldtimeapi.model.WorldTimeResponse;
import com.intuit.worldtimeapi.service.WorldTimeService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/timezone")
public class WorldTimeController {
    @Autowired
    WorldTimeService worldTimeService;
    @Autowired
    WorldTimeResponse WorldTimeResponse;

    @GetMapping(path = "/", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String[]> getAllTimeZones()
    {
        try {
            String[] result = worldTimeService.getAllTimezone();
            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Area not found");
        }
    }


    @GetMapping(path = "/{area}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String[]> getTimezoneByArea(@PathVariable("area") String area)
    {
        try {
            if(!(area == null || area.isEmpty())){
                String[] result = worldTimeService.getTimezoneByArea(area);
                if(result != null){
                    return new ResponseEntity<>(result, HttpStatus.OK);
                } else {
                    throw new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Please enter correct Area");
                }
            } else {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Area is empty");
            }
        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Area not found");
        }
    }

    @GetMapping(path = "/{area}/{location}", produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WorldTimeResponse> getTimeAndDate(@PathVariable("area") String area,@PathVariable("location") String location)
    {
        try {
            if(!(area == null || area.isEmpty()) && !(location == null || location.isEmpty())){
                WorldTimeResponse result = worldTimeService.getTimeAndDate(area,location);
                if(!result.equals(null)){
                    return new ResponseEntity<>(result, HttpStatus.OK);
                } else {
                    throw new ResponseStatusException(
                            HttpStatus.NOT_FOUND, "Please Enter Valid Location");
                }
            } else {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Area/Location is empty");
            }
        }catch (Exception e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Area/Location not found");
        }
    }

}
