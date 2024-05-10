package com.flightfeather.monitor.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.oas.annotations.EnableOpenApi
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket

/**
 * Date: 2023/10/25
 */
@Configuration
@EnableOpenApi
class Swagger2Configuration {

    companion object {
        const val SWAGGER_SCAN_BASE_PACKAGE = "com.flightfeather.monitor"

        const val VERSION = "1.0.0"
    }

//    @Value("\${springfox.documentation.swagger.v2.enabled}")
    var swagger2Enable: Boolean = true

    @Bean
    fun createRestApi(): Docket =
        Docket(DocumentationType.OAS_30)
            .enable(swagger2Enable)
            .apiInfo(apiInfo())
            .select()
            .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
            .paths(PathSelectors.any())
            .build()


    private fun apiInfo() =
        ApiInfoBuilder()
            .title("监测数据质量分析服务")
            .description("监测数据质量分析服务 API 接口文档")
            .version(VERSION)
            .build()
}