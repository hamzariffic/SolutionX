package com.example.solutionx.model
sealed class ExtraComputation {
    data object HEALTH_RECOMMENDATIONS : ExtraComputation()
    data object DOMINANT_POLLUTANT_CONCENTRATION : ExtraComputation()
    data object POLLUTANT_CONCENTRATION : ExtraComputation()
    data object LOCAL_AQI : ExtraComputation()
    data object POLLUTANT_ADDITIONAL_INFO : ExtraComputation()
    companion object {
        val entries: List<ExtraComputation>
            get() = listOf(HEALTH_RECOMMENDATIONS, DOMINANT_POLLUTANT_CONCENTRATION, POLLUTANT_CONCENTRATION, LOCAL_AQI, POLLUTANT_ADDITIONAL_INFO)

        fun values(): Array<ExtraComputation> {
            return arrayOf(
                HEALTH_RECOMMENDATIONS,
                DOMINANT_POLLUTANT_CONCENTRATION,
                POLLUTANT_CONCENTRATION,
                LOCAL_AQI,
                POLLUTANT_ADDITIONAL_INFO
            )
        }

        fun valueOf(value: String): ExtraComputation {
            return when (value) {
                "HEALTH_RECOMMENDATIONS" -> HEALTH_RECOMMENDATIONS
                "DOMINANT_POLLUTANT_CONCENTRATION" -> DOMINANT_POLLUTANT_CONCENTRATION
                "POLLUTANT_CONCENTRATION" -> POLLUTANT_CONCENTRATION
                "LOCAL_AQI" -> LOCAL_AQI
                "POLLUTANT_ADDITIONAL_INFO" -> POLLUTANT_ADDITIONAL_INFO
                else -> throw IllegalArgumentException("No object com.example.solutionx.model.ExtraComputation.$value")
            }
        }
    }
}
