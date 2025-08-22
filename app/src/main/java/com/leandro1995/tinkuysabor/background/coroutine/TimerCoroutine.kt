package com.leandro1995.tinkuysabor.background.coroutine

import com.leandro1995.tinkuysabor.background.config.TimeType
import com.leandro1995.tinkuysabor.extension.coroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import java.util.concurrent.TimeUnit
import kotlin.coroutines.CoroutineContext

class TimerCoroutine(
    private val dispatcher: CoroutineContext = Dispatchers.Main,
    private val timeType: TimeType,
    private val time: Long
) {

    fun timeStart(method: suspend () -> Unit) {
        coroutineScope(context = dispatcher) {
            delay(timeType())
            method()
        }
    }

    private fun timeType() = when (timeType) {
        TimeType.SECOND -> TimeUnit.SECONDS.toMillis(time)
        TimeType.MINUTE -> TimeUnit.MINUTES.toMillis(time)
        TimeType.HOUR -> TimeUnit.HOURS.toMillis(time)
    }
}