package ru.geekbrains.myweatherapp.ui.view

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import ru.geekbrains.myweatherapp.viewmodel.AppState
import ru.geekbrains.myweatherapp.R
import ru.geekbrains.myweatherapp.model.Weather
import ru.geekbrains.myweatherapp.databinding.MainFragmentBinding
import ru.geekbrains.myweatherapp.viewmodel.MainViewModel

class MainFragment : Fragment() {

    private var _binding : MainFragmentBinding? = null

    private val binding
        get() = _binding

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        val view = _binding!!.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getLiveData().observe(viewLifecycleOwner, Observer<Any> { renderData(it as AppState) })
        viewModel.getWeatherFromLocalSource()
    }

    private fun renderData(appState: AppState) {
        when (appState){
            is AppState.Success -> {
                val weatherData = appState.weatherData
                _binding!!.loadingLayout.visibility = View.GONE
                setData(weatherData)

            }
            is AppState.Loading -> {
                _binding!!.loadingLayout.visibility = View.VISIBLE
            }
            is AppState.Error -> {
                _binding!!.loadingLayout.visibility = View.GONE
                Snackbar
                    .make(_binding!!.mainView, "Error", Snackbar.LENGTH_INDEFINITE)
                    .setAction("Reload") { viewModel.getWeatherFromLocalSource() }
                    .show()
            }

        }
    }

    private fun setData(weatherData: Weather) {
        _binding!!.cityName.text = weatherData.city.city
        _binding!!.cityCoordinates.text = String.format(
            getString(R.string.city_coordinates),
            weatherData.city.lat.toString(),
            weatherData.city.lon.toString()
        )
        _binding!!.temperatureValue.text = weatherData.temperature.toString()
        _binding!!.feelsLikeValue.text = weatherData.feelsLike.toString()


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}