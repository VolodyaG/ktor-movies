package com.volodya.configuration

import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*

fun Application.configureGithubOauth() {
    install(Authentication) {
        oauth {
            client = Http.client
            providerLookup = {
                OAuthServerSettings.OAuth2ServerSettings(
                    name = "github",
                    authorizeUrl = "https://github.com/login/oauth/authorize",
                    accessTokenUrl = "https://github.com/login/oauth/access_token",
                    clientId = System.getenv("GITHUB_CLIENT_ID")!!,
                    clientSecret = System.getenv("GITHUB_CLIENT_SECRET")!!
                )
            }
            urlProvider = { redirectUrl() }
        }
    }
}


private fun ApplicationCall.redirectUrl(): String {
    val host = request.host() + ":${request.port()}"
    return "http://$host/login/oauth2"
}