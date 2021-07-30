package ru.geekbrains.myweatherapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.geekbrains.myweatherapp.R
import ru.geekbrains.myweatherapp.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = MainActivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}