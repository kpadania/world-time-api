package com.intuit.worldtimeapi.utils;

import com.intuit.worldtimeapi.model.WorldTimeResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UtilsTest {
    @Autowired
    private Utils utils;
    @Autowired
    private WorldTimeResponse worldTimeResponse;

    @Test
    public void shouldReturnResponseObjectSuccess() {
        String dateTime = "2022-07-21T19:41:59.787024-03:00";
        worldTimeResponse = utils.getTimeandDate(dateTime);
        assertEquals(worldTimeResponse.getTime(), "19:41:59");
        assertEquals(worldTimeResponse.getDate(), "2022-07-21");
    }

}
