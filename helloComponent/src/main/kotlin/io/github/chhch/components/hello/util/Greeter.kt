package io.github.chhch.components.hello.util

import org.apache.logging.log4j.LogManager

class Greeter {

    private val logger = LogManager.getLogger("Greeter")

    fun greet(i: Int) = logger.info("Hello World ($i)")
}