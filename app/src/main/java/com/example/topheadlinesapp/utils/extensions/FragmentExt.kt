package com.example.topheadlinesapp.utils.extensions

import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

fun Fragment.success(recyclerView: RecyclerView,progressBar: ProgressBar, errorMessage: TextView, retry: Button){
    progressBar.visibility = View.GONE
    errorMessage.visibility = View.GONE
    recyclerView.visibility = View.VISIBLE
    retry.visibility = View.GONE
}

fun Fragment.loading(recyclerView: RecyclerView, progressBar: ProgressBar,errorMessage: TextView, retry: Button){
    progressBar.visibility = View.VISIBLE
    errorMessage.visibility = View.GONE
    recyclerView.visibility = View.GONE
    retry.visibility = View.GONE
}

fun Fragment.error(recyclerView: RecyclerView,progressBar: ProgressBar,errorMessage: TextView, retry: Button){
    progressBar.visibility = View.GONE
    errorMessage.visibility = View.VISIBLE
    recyclerView.visibility = View.GONE
    retry.visibility = View.VISIBLE

}

