package io.github.chhch.components.composition

import io.github.chhch.commons.Inject
import io.github.chhch.commons.Logger
import io.github.chhch.commons.Start
import io.github.chhch.commons.Stop
import io.github.chhch.components.LoggerDummy
import io.github.chhch.components.printClassLoaders
import io.github.chhch.components.scoped.ComponentWithScope

class ComponentComposition @Inject constructor(private val logger: Logger) {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            ComponentComposition(LoggerDummy()).apply {
                start()
                stop()
            }
        }
    }

    @Inject
    lateinit var toInject: ComponentWithScope

    init {
        start()
    }

    @Start
    fun start() {
        try {
            printClassLoaders(logger, this, logger, toInject)
            toInject.start()
        } catch (e: UninitializedPropertyAccessException) {
            logger.sendLog("Property was not injected")
        }
    }

    @Stop
    fun stop() {
    }

}