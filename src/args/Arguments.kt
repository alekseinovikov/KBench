package me.freedom4live.kbench.args

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
    val dataFilePath: String?
)
