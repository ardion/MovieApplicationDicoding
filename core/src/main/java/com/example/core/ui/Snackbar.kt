package com.example.core.ui

import android.content.Context
import android.view.View
import com.example.core.R
import com.google.android.material.snackbar.Snackbar

fun showSnackbar(view :View, context: Context){
    val snack = Snackbar.make(view,"Oops..There is something wrong", Snackbar.LENGTH_LONG)
    snack.setBackgroundTint(context.resources.getColor(R.color.error))
    snack.show()
}
