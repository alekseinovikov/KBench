package me.freedom4live.kbench.engine

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import me.freedom4live.kbench.request.RequestPortion
import me.freedom4live.kbench.stats.Stats

object RequestProcessor {

    suspend fun startClient(client: HttpClient, portion: RequestPortion, statsChannel: SendChannel<Stats>) =
        GlobalScope.launch(Dispatchers.IO) {
            val tasks = (1..portion.requestCount).map {
                makeRequest(client, portion, statsChannel)
            }

            tasks.joinAll()
        }

    private suspend fun makeRequest(client: HttpClient, portion: RequestPortion, statsChannel: SendChannel<Stats>) =
        GlobalScope.launch(Dispatchers.IO) {
            val result = client.get<HttpResponse>(portion.url)

            val stats = Stats(result.status.isSuccess())
            statsChannel.send(stats)
        }

}