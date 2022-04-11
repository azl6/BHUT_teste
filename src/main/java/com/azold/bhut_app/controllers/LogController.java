package com.azold.bhut_app.controllers;

import com.azold.bhut_app.domain.Log;
import com.azold.bhut_app.dto.LogResponseDto;
import com.azold.bhut_app.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/logs")
    public ResponseEntity<List<LogResponseDto>> listAllLogs(){
        return ResponseEntity.ok().body(LogService.convertToLogResponseDto(logService.listAllLogs()));
    }
}
