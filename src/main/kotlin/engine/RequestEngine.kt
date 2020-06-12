package me.freedom4live.kbench.engine

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import me.freedom4live.kbench.args.Arguments
import me.freedom4live.kbench.stats.StatsEngine

object RequestEngine {

    suspend fun start(arguments: Arguments) = GlobalScope.launch {
        val client = HttpClient(CIO)
        val statsChannel = StatsEngine.initStatsProcessing()
        val portion = arguments.requestPortion()

        val taskList = (1..arguments.clientsCount).map {
            RequestProcessor.startClient(client, portion, statsChannel)
        }

        taskList.joinAll()
        statsChannel.close()
    }

}