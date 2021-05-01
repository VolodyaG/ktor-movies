package com.volodya.oauth

import com.volodya.configuration.Http
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.client.request.*
import io.ktor.html.*
import io.ktor.http.*
import io.ktor.routing.*
import kotlinx.html.*


fun Routing.addOauthLogin(baseUrl: String) {
    get(baseUrl) {
        call.respondHtml { loginHtml(baseUrl) }
    }

    authenticate {
        get("$baseUrl/oauth2") {
            val user = call.authentication.principal<OAuthAccessTokenResponse.OAuth2>()?.parse()
            val errors = call.parameters.getAll("error")

            if (errors.isNullOrEmpty().not() || user == null) {
                call.respondHtml(status = HttpStatusCode.Unauthorized) { loginHtml(baseUrl) }
            } else {
                call.respondHtml { successHtml(user) }
            }
        }
    }
}

private fun HTML.successHtml(user: GithubUser) {
    head {
        title { +"Logged in" }
    }
    body {
        h1 {
            +"Hello @${user.login}! You looks great today!"
        }
        img(src = user.avatarUrl)
    }
}

private fun HTML.loginHtml(baseUrl: String) {
    head {
        title { +"index page" }
    }
    body {
        h3 {
            +"Try to login with github"
        }
        div {
            a(href = "$baseUrl/oauth2") {
                img {
                    src = "https://github.githubassets.com/images/modules/logos_page/GitHub-Mark.png"
                    height = "150"
                }
            }
        }
    }
}

suspend fun OAuthAccessTokenResponse.OAuth2.parse(): GithubUser {
    val token = this.accessToken
    return Http.client.get("https://api.github.com/user") {
        header(key = HttpHeaders.Authorization, "token $token")
    }
}

data class GithubUser(
    val login: String,
    val avatarUrl: String,
)