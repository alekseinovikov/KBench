package me.freedom4live.kbench.request

import me.freedom4live.kbench.args.RequestType

data class RequestPortion(
    val url: String,
    val requestType: RequestType,
    val requestCount: Int,
    val keepAlive: Boolean,
    val data: ByteArray?
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is RequestPortion) return false

        if (url != other.url) return false
        if (requestType != other.requestType) return false
        if (requestCount != other.requestCount) return false
        if (keepAlive != other.keepAlive) return false
        if (data != null) {
            if (other.data == null) return false
            if (!data.contentEquals(other.data)) return false
        } else if (other.data != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = url.hashCode()
        result = 31 * result + requestType.hashCode()
        result = 31 * result + requestCount
        result = 31 * result + keepAlive.hashCode()
        result = 31 * result + (data?.contentHashCode() ?: 0)
        return result
    }

}