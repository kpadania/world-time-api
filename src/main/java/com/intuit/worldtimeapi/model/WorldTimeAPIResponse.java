package com.intuit.worldtimeapi.model;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.stereotype.Component;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "abbreviation",
        "client_ip",
        "datetime",
        "day_of_week",
        "day_of_year",
        "dst",
        "dst_from",
        "dst_offset",
        "dst_until",
        "raw_offset",
        "timezone",
        "unixtime",
        "utc_datetime",
        "utc_offset",
        "week_number"
})
@Generated("jsonschema2pojo")
@Component
public class WorldTimeAPIResponse {

    @JsonProperty("abbreviation")
    public String abbreviation;
    @JsonProperty("client_ip")
    public String clientIp;
    @JsonProperty("datetime")
    public String datetime;
    @JsonProperty("day_of_week")
    public Integer dayOfWeek;
    @JsonProperty("day_of_year")
    public Integer dayOfYear;
    @JsonProperty("dst")
    public Boolean dst;
    @JsonProperty("dst_from")
    public String dstFrom;
    @JsonProperty("dst_offset")
    public Integer dstOffset;
    @JsonProperty("dst_until")
    public String dstUntil;
    @JsonProperty("raw_offset")
    public Integer rawOffset;
    @JsonProperty("timezone")
    public String timezone;
    @JsonProperty("unixtime")
    public Integer unixtime;
    @JsonProperty("utc_datetime")
    public String utcDatetime;
    @JsonProperty("utc_offset")
    public String utcOffset;
    @JsonProperty("week_number")
    public Integer weekNumber;

    /**
     * No args constructor for use in serialization
     *
     */
    public WorldTimeAPIResponse() {
    }

    /**
     *
     * @param unixtime
     * @param utcOffset
     * @param dst
     * @param dayOfYear
     * @param timezone
     * @param dstOffset
     * @param abbreviation
     * @param dstUntil
     * @param weekNumber
     * @param datetime
     * @param dayOfWeek
     * @param rawOffset
     * @param clientIp
     * @param utcDatetime
     * @param dstFrom
     */
    public WorldTimeAPIResponse(String abbreviation, String clientIp, String datetime, Integer dayOfWeek, Integer dayOfYear, Boolean dst, String dstFrom, Integer dstOffset, String dstUntil, Integer rawOffset, String timezone, Integer unixtime, String utcDatetime, String utcOffset, Integer weekNumber) {
        super();
        this.abbreviation = abbreviation;
        this.clientIp = clientIp;
        this.datetime = datetime;
        this.dayOfWeek = dayOfWeek;
        this.dayOfYear = dayOfYear;
        this.dst = dst;
        this.dstFrom = dstFrom;
        this.dstOffset = dstOffset;
        this.dstUntil = dstUntil;
        this.rawOffset = rawOffset;
        this.timezone = timezone;
        this.unixtime = unixtime;
        this.utcDatetime = utcDatetime;
        this.utcOffset = utcOffset;
        this.weekNumber = weekNumber;
    }

}