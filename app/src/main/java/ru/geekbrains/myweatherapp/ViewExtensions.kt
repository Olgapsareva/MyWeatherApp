package ru.geekbrains.myweatherapp

import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

fun View.showSnackbar(text: String, actionText : String, action: (View) -> Unit){
    Snackbar
        .make(this, text, Snackbar.LENGTH_INDEFINITE)
        .setAction(actionText) { action }
        .show()
}

fun View.showSnackbar(fragment: Fragment, textResource: Int, actionTextResource : Int, action: (View) -> Unit){
    Snackbar
            .make(this, fragment.getString(textResource), Snackbar.LENGTH_INDEFINITE)
            .setAction(fragment.getString(actionTextResource)) { action }
            .show()
}

fun View.showSnackbar(fragment: Fragment, textResource: Int, actionTextResource : Int){
    Snackbar
            .make(this, fragment.getString(textResource), Snackbar.LENGTH_INDEFINITE)
            .show()
}

