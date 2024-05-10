package com.flightfeather.monitor.utils

import java.time.LocalDate

object DateUtil {

    fun findDurationDate(s: LocalDate, e: LocalDate): List<LocalDate> {
        val res = mutableListOf<LocalDate>()
        var sT = s
        while (sT.isBefore(e) || sT.isEqual(e)) {
            res.add(sT)
            sT = sT.plusDays(1)
        }
        return res
    }

    fun findDurationMonth(s: LocalDate, e: LocalDate): List<LocalDate> {
        val res = mutableListOf<LocalDate>()
        var sT = s
        while (sT.monthValue <= e.monthValue) {
            res.add(sT)
            sT = sT.plusMonths(1)
        }
        return res
    }
}