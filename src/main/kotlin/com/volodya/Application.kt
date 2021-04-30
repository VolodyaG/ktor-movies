package com.volodya

import com.volodya.configuration.configureSerialization
import com.volodya.configuration.connectToDatabase
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080) {
        configureSerialization()
        configureRouting()
        connectToDatabase()
    }.start(wait = true)
}
