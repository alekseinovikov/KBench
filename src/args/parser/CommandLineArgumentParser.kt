package me.freedom4live.kbench.args.parser

import kotlinx.cli.*
import me.freedom4live.kbench.args.Arguments
import me.freedom4live.kbench.args.RequestType

object CommandLineArgumentParser {

    private val parser = ArgParser("kbench")

    private val url by parser.option(
        ArgType.String,
        shortName = "u",
        fullName = "url",
        description = "URL for request"
    ).required()

    private val requestType by parser.option(
        ArgType.Choice(listOf("GET", "POST")),
        shortName = "m",
        fullName = "method",
        description = "HTTP method"
    ).default("GET")

    private val clientCount by parser.option(
        ArgType.Int,
        shortName = "c",
        fullName = "clients",
        description = "Clients count"
    ).default(1)

    private val requestCount by parser.option(
        ArgType.Int,
        shortName = "r",
        fullName = "requests",
        description = "Requests per client"
    ).default(1)

    private val keepAlive by parser.option(
        ArgType.Boolean,
        shortName = "k",
        fullName = "keepAlive",
        description = "Keep connection alive"
    ).default(false)

    private val dataFilePath by parser.option(
        ArgType.String,
        shortName = "d",
        fullName = "data",
        description = "Request data"
    )


    fun parse(args: Array<String>): Arguments {
        parser.parse(args)

        return Arguments(
            url = url,
            requestType = RequestType.valueOf(requestType),
            clientsCount = clientCount,
            requestCount = requestCount,
            keepAlive = keepAlive,
            dataFilePath = dataFilePath
        )
    }

}
