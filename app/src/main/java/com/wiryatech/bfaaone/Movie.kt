package com.wiryatech.bfaaone

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie (

    var poster: Int? = 0,
    var title: String? = "",
    var overview: String? = "",
    var score: String? = "",
    var genre: String? = "",
    var date: String? = "",
    var duration: String? = "",
    var slogan: String? = ""

) : Parcelable