package com.volodya.movies

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Routing.addMoviesRouting(basePath: String) {
    get(basePath) {
        val limit = call.request.queryParameters["limit"]?.toInt() ?: 20
        val offset = call.request.queryParameters["offset"]?.toInt() ?: 0

        call.respond(
            MovieService.getMovies(limit, offset)
        )
    }

    get("$basePath/{id}") {
        val id = call.parameters["id"]!!.toInt()

        call.respond(
            MovieService.getMovieById(id)
        )
    }
}