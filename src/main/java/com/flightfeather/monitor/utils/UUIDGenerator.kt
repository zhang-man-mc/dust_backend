package com.flightfeather.monitor.utils

import org.apache.commons.logging.LogFactory
import java.net.InetAddress
import java.security.SecureRandom
import java.util.*
import kotlin.experimental.and

class UUIDGenerator {
    private var midValue: String? = null
    private var seeder: SecureRandom? = null

    init {
        midValue = null
        seeder = null
        val buffer = StringBuffer(16)
        buffer.append(midValueStatic)
        buffer.append(toHex(System.identityHashCode(this), 8))
        midValue = buffer.toString()
        seeder = SecureRandom()
        seeder!!.nextInt()
    }

    fun generate(): String {
        val uid = StringBuffer(32)
        val currentTimeMillis = System.currentTimeMillis()
        uid.append(toHex((currentTimeMillis and -1L).toInt(), 8))
        uid.append(midValue)
        uid.append(toHex(seeder!!.nextInt(), 8))
        return uid.toString()
    }

    companion object {

        private val log = LogFactory.getLog(UUIDGenerator::class.java)

        private var seederStatic: SecureRandom? = null
        private var addr: ByteArray? = null
        private var midValueStatic: String? = null
        private var prevMillis = 0L
        private var addrBytes: ByteArray? = null

        init {
            seederStatic = null
            addr = null
            try {
                addr = InetAddress.getLocalHost().address
                addrBytes = InetAddress.getLocalHost().address
                val buffer = StringBuffer(8)
                buffer.append(toHex(toInt(addr!!), 8))
                midValueStatic = buffer.toString()
                seederStatic = SecureRandom()
                seederStatic!!.nextInt()
            } catch (ex: Exception) {
                log.error("", ex)
            }

        }

        fun generate(obj: Any): String {
            val uid = StringBuffer(32)
            val currentTimeMillis = System.currentTimeMillis()
            uid.append(toHex((currentTimeMillis and -1L).toInt(), 8))
            uid.append(midValueStatic)
            uid.append(toHex(System.identityHashCode(obj), 8))
            uid.append(toHex(random, 8))
            return uid.toString()
        }

        fun generate16(obj: Any): String {
            val uid = StringBuffer(16)
            uid.append(toHex(System.identityHashCode(obj), 8))
            uid.append(toHex(random, 8))
            return uid.toString()
        }

        private fun toHex(v: Int, length: Int): String {
            var value = v
            val hexDigits = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')
            val buffer = StringBuffer(length)
            val shift = length - 1 shl 2
            var i = -1
            while (++i < length) {
                buffer.append(hexDigits[value shr shift and 0xf])
                value = value shl 4
            }

            return buffer.toString()
        }

        private fun toInt(bytes: ByteArray): Int {
            var value = 0
            var i = -1
            while (++i < bytes.size) {
                value = value shl 8
                value = value or bytes[i].toInt()
            }

            return value
        }

        private val random: Int
            @Synchronized get() = seederStatic!!.nextInt()

        private val systemTimeMillis: Long
            @Synchronized get() {
                val millis = System.currentTimeMillis()
                if (millis > prevMillis) {
                    prevMillis = millis
                } else {
                    prevMillis++
                }
                return prevMillis
            }

        val uniqueLong: Long
            get() {
                var l = systemTimeMillis
                l *= 1000L
                val b1 = (addrBytes!![3] and 0xff.toByte()).toLong()
                l += b1
                return java.lang.Long.valueOf(l)
            }

        var chars = arrayOf(
            "a",
            "b",
            "c",
            "d",
            "e",
            "f",
            "g",
            "h",
            "i",
            "j",
            "k",
            "l",
            "m",
            "n",
            "o",
            "p",
            "q",
            "r",
            "s",
            "t",
            "u",
            "v",
            "w",
            "x",
            "y",
            "z",
            "0",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",
            "K",
            "L",
            "M",
            "N",
            "O",
            "P",
            "Q",
            "R",
            "S",
            "T",
            "U",
            "V",
            "W",
            "X",
            "Y",
            "Z"
        )


        /*
    * 长度为8位的UUID
     */
        fun generateShortUUID(): String {
            val shortBuffer = StringBuffer()
            val uuid = UUID.randomUUID().toString().replace("-", "")
            for (i in 0..7) {
                val str = uuid.substring(i * 4, i * 4 + 4)
                val x = Integer.parseInt(str, 16)
                shortBuffer.append(chars[x % 0x3E])
            }
            return shortBuffer.toString()

        }

        /*
    * 长度为16位的UUID
     */
        fun generate16ShortUUID(): String {
            val shortBuffer = StringBuffer()
            val uuid = UUID.randomUUID().toString().replace("-", "")
            for (i in 0..15) {
                val str = uuid.substring(i * 2, i * 2 + 2)
                val x = Integer.parseInt(str, 16)
                shortBuffer.append(chars[x % 0x3E])
            }
            return shortBuffer.toString()

        }

        /**
         * 长度为指定位数的UUID
         * @param uuidLength
         * @return
         */
        fun generateUUID(uuidLength: Int): String {
            val shortBuffer = StringBuffer()
            val uuid = UUID.randomUUID().toString().replace("-", "")
            for (i in 0 until uuidLength) {
                val str = uuid.substring(i * 4, i * 4 + 4)
                val x = Integer.parseInt(str, 16)
                shortBuffer.append(chars[x % 0x3E])
            }
            return shortBuffer.toString()

        }
    }
}