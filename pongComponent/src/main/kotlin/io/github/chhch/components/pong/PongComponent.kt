package io.github.chhch.components.pong

import io.github.chhch.commons.*
import io.github.chhch.components.EventDummy
import io.github.chhch.components.LoggerDummy

class PongComponent @Inject constructor(private val logger: Logger, private val countEvent: Event<Int>) {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            PongComponent(LoggerDummy(), EventDummy()).apply {
                start()
                stop()
                onStatusChange("Call status change method")
            }
        }
    }

    private var counter = 0

    @Start
    fun start() {
    }

    @Stop
    fun stop() {
    }

    @Observer
    fun onStatusChange(event: String) {
        logger.sendLog("Received event: \"$event\"")
        logger.sendLog("Increase counter")
        counter++
        logger.sendLog("Send event: \"$counter\"")
        countEvent.fire(counter)
    }

}