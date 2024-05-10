package com.flightfeather.monitor.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuditInfo {
    private String auditId;
    private  int exceptionId;
    private  String checker;
    private  String checkerContent;
    private  String enterpriseContent;
    private  int auditStatus;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}

