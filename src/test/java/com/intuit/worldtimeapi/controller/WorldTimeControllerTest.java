package com.intuit.worldtimeapi.controller;


import com.intuit.worldtimeapi.model.WorldTimeResponse;
import com.intuit.worldtimeapi.service.WorldTimeService;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
public class WorldTimeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WorldTimeService worldTimeService;

    @Test
    public void shouldReturnTimeZonesSuccess() throws Exception {

        when(worldTimeService.getAllTimezone())
                .thenReturn(createResponseObjectForAllTimezone());

        mockMvc
                .perform(get("/api/timezone/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

   @Test
    public void shouldReturnTimeZonesFailure() throws Exception {

       mockMvc.perform(get("/api/timezone").contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturnTimeZonesWithAreaSuccess() throws Exception {

        when(worldTimeService.getTimezoneByArea("America"))
                .thenReturn(createResponseObjectForAllTimezone());

        mockMvc
                .perform(get("/api/timezone/America")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void shouldReturnTimeZonesWithAreaFailure() throws Exception {

        mockMvc.perform(get("/api/timezone/Toronto").contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isNotFound());
    }

    @Test
    public void shouldReturnDateAndTimeSuccess() throws Exception {

        when(worldTimeService.getTimeAndDate("America","Toronto"))
                .thenReturn(createResponseObjectForDateAndTime());

        mockMvc
                .perform(get("/api/timezone/America/Toronto")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect( jsonPath("$.time", notNullValue()))
                .andExpect( jsonPath("$.date", notNullValue()));
    }

    @Test
    public void shouldReturnDateAndTimeFailure() throws Exception {

        mockMvc.perform(get("/api/timezone/America/Montreal").contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isNotFound());
    }


    private WorldTimeResponse createResponseObjectForDateAndTime() {

        final WorldTimeResponse response = new WorldTimeResponse();
        response.setTime("17:39:24");
        response.setDate("2022-07-21");

        return response;
    }

    private String[] createResponseObjectForAllTimezone() {

        final String[] timeZones = {"Africa/Abidjan",
                "Africa/Accra",
                "Africa/Algiers",
                "Africa/Bissau",
                "Africa/Cairo",
                "Africa/Casablanca",
                "Africa/Ceuta",
                "Africa/El_Aaiun",
                "Africa/Johannesburg",
                "Africa/Juba",
                "Africa/Khartoum",
                "Africa/Lagos",
                "Africa/Maputo",
                "Africa/Monrovia",
                "Africa/Nairobi",
                "Africa/Ndjamena",
                "Africa/Sao_Tome",
                "Africa/Tripoli"};

        return timeZones;
    }

    private String[] createResponseObjectForGivenTimezone() {

        final String[] timeZones = {"America/Atikokan",
                "America/Bahia",
                "America/Bahia_Banderas",
                "America/Barbados",
                "America/Belem",
                "America/Belize",
                "America/Blanc-Sablon",
                "America/Boa_Vista",
                "America/Bogota",
                "America/Boise",
                "America/Cambridge_Bay",
                "America/Campo_Grande",
                "America/Cancun",
                "America/Caracas"};

        return timeZones;
    }

}
