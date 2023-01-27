package com.example.topheadlinesapp.data.model.local

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HeadLinesItem(
    val title: String?,
    val date: String?,
    val description: String?,
    val content: String?,
    val imageUrl: String?,
    val publishedAt: String?
): Parcelable