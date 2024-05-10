package com.flightfeather.monitor.enumration.dust

enum class ExceptionType(val value:Int, val des:String) {
    TYPE0(0, "数据缺失异常"),
    TYPE1(1, "数据超低异常"),
    TYPE2(2, "数据超标"),
    TYPE3(3, "数据长时段无波动"),
    TYPE4(4, "量级突变异常"),
    TYPE5(5, "临近超标异常"),
    TYPE6(6, "单日超标次数临近处罚异常"),
    TYPE7(7, "滑动平均值突变异常"),
    TYPE8(8, "有效率异常"),
}