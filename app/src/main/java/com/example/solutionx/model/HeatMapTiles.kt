package com.example.solutionx.model

data class HeatmapTileRequest(
    val mapType: MapType,
    val zoom: Int,
    val x: Int,
    val y: Int
)

enum class MapType {
    UAQI_RED_GREEN,
    UAQI_INDIGO_PERSIAN,
    PM25_INDIGO_PERSIAN,
    GBR_DEFRA,
    DEU_UBA,
    CAN_EC,
    FRA_ATMO,
    US_AQI
}

data class HeatmapTileResponse(
    val contentType: String,
    val data: ByteArray,
    val extensions: List<Any>
) {
    val isSuccessful: Boolean
        get() = contentType == "image/png"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as HeatmapTileResponse

        if (contentType != other.contentType) return false
        if (!data.contentEquals(other.data)) return false
        return extensions == other.extensions
    }

    override fun hashCode(): Int {
        var result = contentType.hashCode()
        result = 31 * result + data.contentHashCode()
        result = 31 * result + extensions.hashCode()
        return result
    }

    private fun getBytes(): ByteArray {
        return data
    }
}
