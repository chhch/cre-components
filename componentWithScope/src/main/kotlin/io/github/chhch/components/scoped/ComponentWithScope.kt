package io.github.chhch.components.scoped

import io.github.chhch.commons.*
import io.github.chhch.components.LoggerDummy
import io.github.chhch.components.printClassLoaders

@Scope([(Lifecycle.IN_PRODUCTION), (Lifecycle.UNDER_INSPECTION)])
class ComponentWithScope @Inject constructor(private val logger: Logger) {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            ComponentWithScope(LoggerDummy()).apply {
                start()
                stop()
            }
        }
    }

    init {
        start()
    }

    @Start
    fun start() {
        printClassLoaders(logger, this, logger)
    }

    @Stop
    fun stop() {
    }

}