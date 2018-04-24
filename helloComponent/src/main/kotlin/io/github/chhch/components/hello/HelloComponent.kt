package io.github.chhch.components.hello

import io.github.chhch.commons.Start
import io.github.chhch.commons.Stop
import io.github.chhch.components.hello.util.Greeter
import io.github.chhch.components.printClassLoaders
import org.apache.logging.log4j.LogManager

class HelloComponent {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            HelloComponent().apply {
                start()
                stop()
            }
        }
    }

    private val logger = LogManager.getLogger("HelloComponent")

    init {
        printClassLoaders(null, this, logger)
    }

    @Start
    fun start() {
        logger.info("Prints 10 times 'Hello World'")
        val greeter = Greeter()
        for (i in 1..10) {
            greeter.greet(i)
            Thread.sleep(1_000)
        }
        logger.info("Finished!")
    }

    @Stop
    fun stop() {
        logger.info("Shutting down")
        for (i in 3 downTo 0) {
            logger.info("$i... ")
            Thread.sleep(1_000)
        }
        logger.info("Bye.")
    }

}