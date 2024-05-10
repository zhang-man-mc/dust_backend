package com.flightfeather.monitor.analysis

/**
 * 数据分析基类
 */
abstract class BaseDataAnalysis<T, V, Y>(val config: V) {

    //分析结果
    val resultList = mutableListOf<Y>()

    /**
     * 配置初始化
     */
    open fun init(){
        resultList.clear()
    }

    /**
     * 接收下一个时间点的数据
     */
    abstract fun onNextData(data: T)

    /**
     * 数据循环结束
     */
    abstract fun onDone()
}