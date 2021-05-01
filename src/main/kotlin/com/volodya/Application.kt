package com.volodya

import com.volodya.configuration.configureGithubOauth
import com.volodya.configuration.configureSerialization
import com.volodya.configuration.connectToDatabase
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 8080) {
        install(CallLogging)
        configureSerialization()
        configureGithubOauth()
        configureRouting()
        connectToDatabase()
    }.start(wait = true)
}
