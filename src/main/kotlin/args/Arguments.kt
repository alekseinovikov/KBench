package me.freedom4live.kbench.args

import me.freedom4live.kbench.data.FileDataLoader
import me.freedom4live.kbench.request.RequestPortion

enum class RequestType {
    GET,
    POST
}

data class Arguments(
    val url: String,
    val requestType: RequestType = RequestType.GET,
    val clientsCount: Int = 1,
    val requestCount: Int = 1,
    val keepAlive: Boolean = false,
    val dataFilePath: String? = null
) {

    fun requestPortion() = RequestPortion(
        url = url,
        requestType = requestType,
        requestCount = requestCount,
        keepAlive = keepAlive,
        data = getData()
    )

    private fun getData() = dataFilePath?.let { FileDataLoader.load(it) }

}