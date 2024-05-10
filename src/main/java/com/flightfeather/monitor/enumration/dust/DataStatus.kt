package com.flightfeather.monitor.enumration.dust

enum class DataStatus(val value: String, val des: String) {
    N("N", "正常"),
    C("C", "设备校准"),
    D("D", "设备断开"),
    P("P", "一起电源故障"),
    OUT_MIN("-", "超过数据设定范围下限"),
    OUT_MAX("+", "超过数据设定范围上限"),
    Q("Q", "低于全市国控点PM2.5平均浓度二分之一"),
    VALID(">", "颗粒物有效数据大于90%"),
    INVALID("<", "颗粒物有效数据小于90%"),
    R("R", "风速大于8m/s和雨、雪等天气条件"),
    J("J", "开展计量检定或比对测试"),
    A("A", "补传"),
}