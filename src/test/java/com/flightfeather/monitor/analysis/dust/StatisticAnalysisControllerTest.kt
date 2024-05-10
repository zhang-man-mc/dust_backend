package com.flightfeather.monitor.analysis.dust

import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringRunner
import java.time.LocalDate

@RunWith(SpringRunner::class)
@ExtendWith(SpringExtension::class)
@SpringBootTest
class StatisticAnalysisControllerTest {
    @Autowired
    lateinit var statisticAnalysisController: StatisticAnalysisController

    @Test
    fun dailyStatics() {
        val d = LocalDate.of(2023, 7, 2)
        statisticAnalysisController.dailyStatics(d)
    }

    @Test
    fun monthlyStatics() {
        val d = LocalDate.of(2023, 7, 1)
        statisticAnalysisController.monthlyStatics(d)
    }

    @Test
    fun autoRunDailyStatics() {
        statisticAnalysisController.autoRunDailyStatics()
    }

    @Test
    fun autoRunMonthlyStatics() {
        statisticAnalysisController.autoRunMonthlyStatics()
    }
}