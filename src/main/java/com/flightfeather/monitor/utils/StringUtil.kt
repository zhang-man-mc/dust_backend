package com.flightfeather.monitor.utils

/**
 * 文本工具
 */
object StringUtil {

    /**
     * 驼峰命名法文本转下划线文本
     * @param t
     * @return
     */
    fun camelCaseToUnderline(t: String?): String? {
        t ?: return null

        val result = StringBuilder()
        t.forEach {
            if (it.isUpperCase()) {
                result.append('_')
                result.append(it.lowercaseChar())
            } else {
                result.append(it)
            }
        }
        return result.toString()
    }
}