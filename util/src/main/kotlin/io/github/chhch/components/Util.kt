package io.github.chhch.components

import io.github.chhch.commons.Event
import io.github.chhch.commons.EventQualifier
import io.github.chhch.commons.Logger
import io.github.chhch.commons.Start
import java.time.LocalDateTime

@EventQualifier
annotation class MyCustomEvent

data class MyCustomData(val data: String, val timestamp: LocalDateTime)

class LoggerDummy : Logger {
    override fun sendLog(message: String) = println("[Dummy] Component-Log: $message")
}

class EventDummy : Event<Any> {
    override fun fire(event: Any) = println("[Dummy] Event fired: \"$event\"")
}

fun printClassLoaders(logger: Logger?, vararg objects: Any) = objects.map { it::class.java }
                .plus(listOf(Any::class.java, Start::class.java))
                .forEach {
                    val message = "${it.name} was loaded with class loader '${it.classLoader}'"
                    logger?.sendLog(message) ?: println(message)
                }