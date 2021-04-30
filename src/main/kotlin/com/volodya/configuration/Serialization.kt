package com.volodya.configuration

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.SerializationFeature
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.jackson.*

fun Application.configureSerialization() {
    install(ContentNegotiation) {
        jackson {
            enable(SerializationFeature.WRAP_ROOT_VALUE)
            propertyNamingStrategy = PropertyNamingStrategy.SNAKE_CASE
        }
    }
}
