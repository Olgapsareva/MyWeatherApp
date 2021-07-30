package ru.geekbrains.myweatherapp.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.geekbrains.myweatherapp.R
import ru.geekbrains.myweatherapp.model.Weather
import ru.geekbrains.myweatherapp.databinding.DetailsFragmentBinding
import ru.geekbrains.myweatherapp.viewmodel.MainViewModel

class DetailsFragment : Fragment() {

    private var _binding: DetailsFragmentBinding? = null

    private val binding
        get() = _binding


    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailsFragmentBinding.inflate(inflater, container, false)
        val view = _binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val weather = arguments?.getParcelable<Weather>(BUNDLE_EXTRA)
        if (weather != null) {
            val city = weather.city
            binding!!.cityName.text = city.cityName
            binding!!.cityCoordinates.text = String.format(
                getString(R.string.city_coordinates),
                city.lat.toString(),
                city.lon.toString()
            )
            binding?.temperatureValue?.text = weather.temperature.toString()
            binding?.feelsLikeValue?.text = weather.feelsLike.toString()

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        const val BUNDLE_EXTRA = "weather"

        fun newInstance(bundle: Bundle): DetailsFragment {
            val fragment = DetailsFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}
