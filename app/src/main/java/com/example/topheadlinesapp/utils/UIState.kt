package com.example.topheadlinesapp.utils

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

fun success(recyclerView: RecyclerView,progressBar: ProgressBar, errorMessage: TextView, retry: Button){
    progressBar.visibility = View.GONE
    errorMessage.visibility = View.GONE
    recyclerView.visibility = View.VISIBLE
    retry.visibility = View.GONE
}
fun loading(recyclerView: RecyclerView, progressBar: ProgressBar,errorMessage: TextView, retry: Button){
    progressBar.visibility = View.VISIBLE
    errorMessage.visibility = View.GONE
    recyclerView.visibility = View.GONE
    retry.visibility = View.GONE
}
fun error(recyclerView: RecyclerView,progressBar: ProgressBar,errorMessage: TextView, retry: Button){
    progressBar.visibility = View.GONE
    errorMessage.visibility = View.VISIBLE
    recyclerView.visibility = View.GONE
    retry.visibility = View.VISIBLE

}

