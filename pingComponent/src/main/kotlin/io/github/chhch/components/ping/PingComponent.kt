package io.github.chhch.components.ping

import io.github.chhch.commons.*
import io.github.chhch.components.EventDummy
import io.github.chhch.components.LoggerDummy

class PingComponent @Inject constructor(private val logger: Logger, private val changeStatusEvent: Event<String>) {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            PingComponent(LoggerDummy(), EventDummy()).apply {
                start()
                stop()
                onCount(1)
            }
        }
    }

    @Start
    fun start() {
        val event = "Component Ping started"
        logger.sendLog("Send event: \"$event\"")
        changeStatusEvent.fire(event)
    }

    @Stop
    fun stop() {
        val event = "Component Ping stopped"
        logger.sendLog("Send event: \"$event\"")
        changeStatusEvent.fire(event)
    }

    @Observer
    fun onCount(event: Int) {
        logger.sendLog("Received event: \"$event\"")
    }

}