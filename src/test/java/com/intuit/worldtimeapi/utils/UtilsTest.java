package com.intuit.worldtimeapi.utils;

import com.intuit.worldtimeapi.model.WorldTimeResponse;
import com.intuit.worldtimeapi.service.WorldTimeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class UtilsTest {
    @Autowired
    private Utils utils;
    @Autowired
    private WorldTimeResponse worldTimeResponse;

    @Test
    public void shouldReturnResponseObjectSuccess() throws Exception {
        String dateTime = "2022-07-21T19:41:59.787024-03:00";
        worldTimeResponse = utils.getTimeandDate(dateTime);
        assertEquals(worldTimeResponse.getTime(), "19:41:59");
        assertEquals(worldTimeResponse.getDate(), "2022-07-21");
    }

}
