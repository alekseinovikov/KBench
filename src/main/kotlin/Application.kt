package me.freedom4live.kbench

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.util.KtorExperimentalAPI
import kotlinx.coroutines.runBlocking
import me.freedom4live.kbench.args.parser.CommandLineArgumentParser

@KtorExperimentalAPI
fun main(args: Array<String>): Unit = runBlocking {
    val arguments = CommandLineArgumentParser.parse(args)

    val client = HttpClient(CIO)
    val result = client.get<HttpResponse>(arguments.url)

    println(result.status)
}
