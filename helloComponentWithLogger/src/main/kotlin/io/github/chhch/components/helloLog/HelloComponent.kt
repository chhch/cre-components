package io.github.chhch.components.helloLog

import io.github.chhch.commons.Inject
import io.github.chhch.commons.Logger
import io.github.chhch.commons.Start
import io.github.chhch.commons.Stop
import io.github.chhch.components.LoggerDummy
import io.github.chhch.components.helloLog.util.Greeter
import io.github.chhch.components.printClassLoaders

class HelloComponent @Inject constructor(private val logger: Logger) {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            HelloComponent(LoggerDummy()).apply {
                start()
                stop()
            }
        }
    }

    init {
        printClassLoaders(logger, this, logger)
    }

    @Start
    fun start() {
        logger.sendLog("Prints 10 times 'Hello World'")
        val greeter = Greeter(logger)
        for (i in 1..10) {
            greeter.greet(i)
            Thread.sleep(1_000)
        }
        logger.sendLog("Finished!")
    }

    @Stop
    fun stop() {
        logger.sendLog("Shutting down")
        for (i in 3 downTo 0) {
            logger.sendLog("$i... ")
            Thread.sleep(1_000)
        }
        logger.sendLog("Bye.")
    }

}