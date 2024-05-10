package com.flightfeather.monitor.enumration.dust

enum class DeviceStatus(val value: Int, val des: String) {
    ONLINE(0, "在线"),
    STOP(1, "停运"),
    OFFLINE(2, "离线"),
}