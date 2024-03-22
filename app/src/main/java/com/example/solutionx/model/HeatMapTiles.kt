package com.example.solutionx.model

//heatmap tile request logic
data class HeatmapTileRequest(
    val mapType: String,
    val zoom: Int,
    val x: Int,
    val y: Int
)

enum class MapType {
    UAQI_INDIGO_PERSIAN,
    PM25_INDIGO_PERSIAN,
    GBR_DEFRA,
    DEU_UBA,
    CAN_EC,
    FRA_ATMO,
    US_AQI
}


//Heatmap tile response
data class HeatmapTileResponse(
    val contentType: String,
    val data: ByteArray,
    val extensions: List<Any>,
    val errorMessage: String? = null //only used in case of error
) {
//    Error handling
    val isSuccessful: Boolean
        get() = contentType == "image/png" && data.isNotEmpty()
    val isError: Boolean
        get() = !isSuccessful

    fun hasError(): Boolean {
        return isError || errorMessage != null
    }

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

}