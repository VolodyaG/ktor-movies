package com.volodya

import com.volodya.movies.addMoviesRouting
import com.volodya.oauth.addOauthLogin
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureRouting() {
    routing {
        addDummyRouting("/dummy")
        addMoviesRouting("/movies")
        addOauthLogin("/login")
    }
}


fun Routing.addDummyRouting(basePath: String) {
    get(basePath) {
        call.respondText("Mew!")
    }
}