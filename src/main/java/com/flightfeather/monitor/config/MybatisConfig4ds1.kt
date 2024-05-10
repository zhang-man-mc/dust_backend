package com.flightfeather.monitor.config

import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.SqlSessionTemplate
import org.mybatis.spring.annotation.MapperScan
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import javax.sql.DataSource


/**
 * Mybatis主数据源ds1配置
 * 多数据源配置依赖数据源配置
 * @see  DataSourceConfig
 */
@Configuration
@MapperScan(basePackages = ["com.flightfeather.monitor.domain.ds1.mapper", "com.flightfeather.monitor.mapper"],
    sqlSessionTemplateRef = "ds1SqlSessionTemplate", sqlSessionFactoryRef = "ds1SqlSessionFactory")
class MybatisConfig4ds1 {

    //主数据源 ds1数据源
    @Primary
    @Bean("ds1SqlSessionFactory")
    @Throws(Exception::class)
    fun ds1SqlSessionFactory(
        @Qualifier("ds1DataSource") dataSource: DataSource?,
        @Qualifier("ds1MybatisConfiguration") configuration: org.apache.ibatis.session.Configuration,
    ): SqlSessionFactory? {
        val sqlSessionFactory = SqlSessionFactoryBean()
        sqlSessionFactory.setDataSource(dataSource)
        sqlSessionFactory.setMapperLocations(*PathMatchingResourcePatternResolver().getResources
            ("classpath*:mapper/**/*.xml"))
        sqlSessionFactory.setConfiguration(configuration)
        return sqlSessionFactory.getObject()
    }

    @Primary
    @Bean(name = ["ds1TransactionManager"])
    fun ds1TransactionManager(@Qualifier("ds1DataSource") dataSource: DataSource): DataSourceTransactionManager? {
        return DataSourceTransactionManager(dataSource)
    }

    @Primary
    @Bean(name = ["ds1SqlSessionTemplate"])
    fun ds1SqlSessionTemplate(@Qualifier("ds1SqlSessionFactory") sqlSessionFactory: SqlSessionFactory?): SqlSessionTemplate? {
        return SqlSessionTemplate(sqlSessionFactory)
    }

    @Bean(name = ["ds1MybatisConfiguration"])
    @ConfigurationProperties(prefix = "mybatis.configuration")
    fun ds1MybatisConfiguration(): org.apache.ibatis.session.Configuration {
        return org.apache.ibatis.session.Configuration()
    }

}