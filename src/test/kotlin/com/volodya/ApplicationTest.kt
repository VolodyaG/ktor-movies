package com.volodya

import io.ktor.http.*
import io.ktor.server.testing.*
import kotlin.test.Test
import kotlin.test.assertEquals

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ configureRouting() }) {
            handleRequest(HttpMethod.Get, "/dummy").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Mew", response.content)
            }
        }
    }
}