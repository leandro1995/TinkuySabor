package com.leandro1995.tinkuysabor.background.coroutine

import com.leandro1995.tinkuysabor.background.config.TimeType
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import kotlin.coroutines.CoroutineContext

class TimerCoroutine(
    private val dispatcher: CoroutineContext = Dispatchers.Main,
    private val timeType: TimeType,
    private val time: Long
) {

    fun timeStart(method: () -> Unit) {
        CoroutineScope(dispatcher).launch {
            timeType().sleep(time)
            method()
        }
    }

    private fun timeType() = when (timeType) {
        TimeType.SECOND -> TimeUnit.SECONDS
        TimeType.MINUTE -> TimeUnit.MINUTES
        TimeType.HOUR -> TimeUnit.HOURS
    }
}