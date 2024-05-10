package com.flightfeather.monitor.domain.ds1.repository

import com.flightfeather.monitor.domain.ds1.entity.DustExceptionSetting
import com.flightfeather.monitor.domain.ds1.mapper.DustExceptionSettingMapper
import com.github.pagehelper.PageHelper
import org.springframework.stereotype.Repository
import tk.mybatis.mapper.entity.Example

@Repository
class DustExceptionSettingRep(private val dustExceptionSettingMapper: DustExceptionSettingMapper) {

    /**
     * 获取最新配置
     * @param region 区县
     */
    fun findLatestSetting(region: String): DustExceptionSetting? {
        val p = PageHelper.startPage<DustExceptionSetting>(1, 1)
        dustExceptionSettingMapper.selectByExample(Example(DustExceptionSetting::class.java).apply {
            createCriteria().andEqualTo("region", region)
            orderBy("version").desc()
        })
        return if (p.isNotEmpty()) {
            p[0]
        } else {
            null
        }
    }
}