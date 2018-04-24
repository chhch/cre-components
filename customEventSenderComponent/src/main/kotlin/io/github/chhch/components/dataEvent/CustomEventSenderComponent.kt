package io.github.chhch.components.dataEvent

import io.github.chhch.commons.*
import io.github.chhch.components.*
import java.time.LocalDateTime

class CustomEventSenderComponent @Inject constructor(
        private val logger: Logger,
        @MyCustomEvent private val customDataEvent: Event<MyCustomData>
) {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            CustomEventSenderComponent(LoggerDummy(), EventDummy()).apply {
                start()
                stop()
            }
        }
    }

    @Start
    fun start() {
        val data = MyCustomData("Das ist ein Test", LocalDateTime.now())
        logger.sendLog("Send: $data")
        printClassLoaders(logger, this, logger, customDataEvent, data)
        customDataEvent.fire(data)
    }

    @Stop
    fun stop() {
    }

}