package com.flightfeather.monitor.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//设备信息表
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceInfo {
    private String diGuid;
    private String diCode;
    private String diName;
    private String diSupplier;
    private String diOnline;
}
