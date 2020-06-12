package me.freedom4live.kbench.stats

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.SendChannel
import kotlinx.coroutines.launch

object StatsEngine {

    fun initStatsProcessing(): SendChannel<Stats> {
        val channel = Channel<Stats>()
        processChannel(channel)
        return channel
    }

    private fun processChannel(channel: ReceiveChannel<Stats>) {
        GlobalScope.launch {
            for (stats in channel) {
                processStats(stats)
            }
        }
    }

    private suspend fun processStats(stats: Stats) {
        println(stats)
    }

}