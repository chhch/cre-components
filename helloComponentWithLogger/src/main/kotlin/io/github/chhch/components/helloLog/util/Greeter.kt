package io.github.chhch.components.helloLog.util

import io.github.chhch.commons.Logger


class Greeter(private val logger: Logger) {
    fun greet(i: Int) = logger.sendLog("Hello World ($i)")
}