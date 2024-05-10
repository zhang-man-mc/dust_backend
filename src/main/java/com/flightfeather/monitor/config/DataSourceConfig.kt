package com.flightfeather.monitor.config

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import javax.sql.DataSource


/**
 * 多数据源配置
 */
@Configuration
class DataSourceConfig {

    //主数据源配置 ds1数据源
    @Primary
    @Bean(name = ["ds1DataSourceProperties"])
    @ConfigurationProperties(prefix = "spring.datasource.ds1")
    fun ds1DataSourceProperties(): DataSourceProperties? {
        return DataSourceProperties()
    }

    //主数据源 ds1数据源
    @Primary
    @Bean(name = ["ds1DataSource"])
    fun ds1DataSource(@Qualifier("ds1DataSourceProperties") dataSourceProperties: DataSourceProperties): DataSource? {
        return dataSourceProperties.initializeDataSourceBuilder().build()
    }

    //第二个ds2数据源配置
//    @Bean(name = ["ds2DataSourceProperties"])
//    @ConfigurationProperties(prefix = "spring.datasource.ds2")
//    fun ds2DataSourceProperties(): DataSourceProperties? {
//        return DataSourceProperties()
//    }

    //第二个ds2数据源
//    @Bean("ds2DataSource")
//    fun ds2DataSource(@Qualifier("ds2DataSourceProperties") dataSourceProperties: DataSourceProperties): DataSource? {
//        return dataSourceProperties.initializeDataSourceBuilder().build()
//    }
}