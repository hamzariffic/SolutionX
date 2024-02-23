package com.example.solutionx.model

import android.os.Parcel

data class Color(
    val red: Parcel,
    val green: Int,
    val blue: Int,
    val alpha: Int?,

  val colorList: List<String> = listOf("#000000", "#009966","#ffcc00", "#ff9900", "#cc0000", "#660066", "#9933cc")
)
