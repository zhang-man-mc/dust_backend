package com.flightfeather.monitor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//扬尘的异常类型实体类
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DustExceptionType {
    private String exception;
    private String exceptionType;
}
