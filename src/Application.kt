package me.freedom4live.kbench

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.required
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>): Unit = runBlocking {
    val parser = ArgParser("kbench")

    val url by parser.option(ArgType.String, shortName = "u", description = "URL for requests").required()

    parser.parse(args)

    val client = HttpClient(CIO)
    val result = client.get<HttpResponse>(url)

    println(result.status)
}
