package com.azold.bhut_app.services;


import com.azold.bhut_app.domain.Car;
import com.azold.bhut_app.domain.Log;
import com.azold.bhut_app.repositories.LogRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class LogServiceTest {

    private LogService logService;

    @MockBean
    LogRepository logRepository;

    @BeforeEach
    public void setUp() {
        this.logService = new LogService(logRepository);
    }

    @Test
    @DisplayName("Should return a list of logs")
    public void testFindAll() {

        Log mockLog1 = new Log(1, "10/04/2022 13:12", "624ed014f8037d001c59e23d");
        Log mockLog2 = new Log(2, "11/04/2022 13:12", "634ed014f8037d001c59e23d");
        Log mockLog3 = new Log(3, "12/04/2022 13:12", "644ed014f8037d001c59e23d");

        Mockito.doReturn(Arrays.asList(mockLog1, mockLog2, mockLog3)).when(logRepository).findAll();
        List<Log> returnedLogList = logService.listAllLogs();

        Assertions.assertEquals(3, returnedLogList.size(), "Logs were found");
    }
}
