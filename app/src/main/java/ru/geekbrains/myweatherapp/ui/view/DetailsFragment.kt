package ru.geekbrains.myweatherapp.ui.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.geekbrains.myweatherapp.R
import ru.geekbrains.myweatherapp.model.Weather
import ru.geekbrains.myweatherapp.databinding.DetailsFragmentBinding

class DetailsFragment : Fragment() {

    private lateinit var binding: DetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailsFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val weather = arguments?.getParcelable<Weather>(BUNDLE_EXTRA)?.let {
            it.city.apply {
                binding.cityName.text = this.cityName
                binding.cityCoordinates.text = String.format(
                    getString(R.string.city_coordinates),
                    this.lat.toString(),
                    this.lon.toString()
                )}
            binding.temperatureValue.text = it.temperature.toString()
            binding.feelsLikeValue.text = it.feelsLike.toString()
             }
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
