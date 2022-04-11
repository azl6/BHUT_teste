package com.azold.bhut_app.services;

import com.azold.bhut_app.domain.Car;
import com.azold.bhut_app.domain.Log;
import com.azold.bhut_app.dto.LogResponseDto;
import com.azold.bhut_app.repositories.LogRepository;
import com.azold.bhut_app.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogService {

    private LogRepository logRepository;

    @Autowired
    public LogService(LogRepository logRepository){
        this.logRepository = logRepository;
    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
    public Log insertNewLogByCar(Car car){
        String date = DateUtils.convertSystemTimeMillisToString(System.currentTimeMillis());
        return logRepository.save(new Log(date, car.get_id()));
    }

    public List<Log> listAllLogs(){
        return logRepository.findAll();
    }

    public static List<LogResponseDto> convertToLogResponseDto(List<Log> logList){
        return logList.stream().map(log -> new LogResponseDto(log.getId(), log.getData_hora(), log.getCar_id()))
                .collect(Collectors.toList());
    }
}