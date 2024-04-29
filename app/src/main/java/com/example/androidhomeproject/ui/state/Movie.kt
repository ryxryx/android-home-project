package com.example.androidhomeproject.ui.state

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val thumbnail: String,
    val title: String,
    val description: String
): Parcelable
