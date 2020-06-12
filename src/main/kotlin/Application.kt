package me.freedom4live.kbench

import io.ktor.util.KtorExperimentalAPI
import kotlinx.coroutines.runBlocking
import me.freedom4live.kbench.args.parser.CommandLineArgumentParser
import me.freedom4live.kbench.engine.RequestEngine

@KtorExperimentalAPI
fun main(args: Array<String>): Unit = runBlocking {
    val arguments = CommandLineArgumentParser.parse(args)
    RequestEngine.start(arguments)
        .join()
}
