package com.volodya.configuration

import com.zaxxer.hikari.HikariDataSource
import io.ktor.application.*
import org.jetbrains.exposed.sql.Database

private val DB_URL = System.getenv("DB_URL") ?: "jdbc:postgresql://localhost:5432/movies_db"
private val DB_USER = System.getenv("DB_USER") ?: "postgres"
private val DB_PASSWORD = System.getenv("DB_PASSWORD") ?: "admin"
private val DB_MAX_POOL = System.getenv("DB_MAX_POOL")?.toInt() ?: 2

fun Application.connectToDatabase() {
    val dataSource = HikariDataSource().apply {
        jdbcUrl = DB_URL
        username = DB_USER
        password = DB_PASSWORD
        maximumPoolSize = DB_MAX_POOL
        driverClassName = "org.postgresql.Driver"
        transactionIsolation = "TRANSACTION_READ_COMMITTED"
        connectionTestQuery = "SELECT 1"
    }
    dataSource.validate()
    Database.connect(dataSource)
}