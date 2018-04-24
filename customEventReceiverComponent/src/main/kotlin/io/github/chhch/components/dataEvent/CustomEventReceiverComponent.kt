package io.github.chhch.components.dataEvent

import io.github.chhch.commons.*
import io.github.chhch.components.LoggerDummy
import io.github.chhch.components.MyCustomData
import io.github.chhch.components.MyCustomEvent
import io.github.chhch.components.printClassLoaders
import java.time.LocalDateTime

class CustomEventReceiverComponent @Inject constructor(private val logger: Logger) {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            CustomEventReceiverComponent(LoggerDummy()).apply {
                start()
                onDataSend(MyCustomData("test", LocalDateTime.now()))
                stop()
            }
        }
    }

    @Start
    fun start() {
    }

    @Stop
    fun stop() {
    }

    @Observer @MyCustomEvent
    fun onDataSend(customData: MyCustomData) {
        logger.sendLog("Received: $customData")
        printClassLoaders(logger, this, logger, customData)
    }

}