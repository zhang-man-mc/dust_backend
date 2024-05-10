package com.flightfeather.monitor.analysis.dust

import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@ExtendWith(SpringExtension::class)
@SpringBootTest
class RiskAnalysisControllerTest {

    @Autowired
    lateinit var riskAnalysisController: RiskAnalysisController

    @Test
    fun autoRunDaily() {
        riskAnalysisController.init()
//        val s = LocalDate.of(2023, 10, 1)
//        val e = LocalDate.of(2023, 10, 31)
//        val du = DateUtil.findDurationDate(s, e)
//        du.forEach {
//            riskAnalysisController.runDaily(it)
//        }
        riskAnalysisController.autoRunDaily()
    }

    @Test
    fun autoRunMonthly() {
        riskAnalysisController.init()
        riskAnalysisController.autoRunMonthly()
    }
}