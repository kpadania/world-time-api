package com.intuit.worldtimeapi.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Component;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "date",
        "time"
})
@Generated("jsonschema2pojo")
@Component
public class WorldTimeResponse {

    @JsonProperty("date")
    private String date;
    @JsonProperty("time")
    private String time;

    /**
     * No args constructor for use in serialization
     *
     */
    public WorldTimeResponse() {
    }

    /**
     *
     * @param date
     * @param time
     */
    public WorldTimeResponse(String date, String time) {
        super();
        this.date = date;
        this.time = time;
    }

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("time")
    public String getTime() {
        return time;
    }

    @JsonProperty("time")
    public void setTime(String time) {
        this.time = time;
    }

}