package com.flightfeather.monitor.analysis.dust

import org.junit.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringRunner
import java.time.Duration
import java.time.LocalDate

@RunWith(SpringRunner::class)
@ExtendWith(SpringExtension::class)
@SpringBootTest
class ExceptionAnalysisControllerTest {

    @Autowired
    lateinit var exceptionAnalysisController: ExceptionAnalysisController

    @Test
    fun autoRun() {
        exceptionAnalysisController.init()
        exceptionAnalysisController.autoRun()
    }

    @Test
    fun run() {
        exceptionAnalysisController.init()
        var d1 = LocalDate.of(2023, 10, 26)
        val d2 = LocalDate.of(2023, 10, 26)
        while (Duration.between(d1.atStartOfDay(), d2.atStartOfDay()).toDays() >= 0L) {
            exceptionAnalysisController.run(d1)
            d1 = d1.plusDays(1)
        }
//        exceptionAnalysisController.debugRun()
    }
}