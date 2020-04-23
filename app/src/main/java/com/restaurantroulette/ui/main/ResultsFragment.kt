package com.restaurantroulette.ui.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.restaurantroulette.MainActivity
import com.restaurantroulette.R
import com.restaurantroulette.dto.Places
import kotlinx.android.synthetic.main.results_fragment.*


class ResultsFragment : Fragment() {


    companion object {
        fun newInstance() = ResultsFragment()
    }



    private lateinit var viewModel : ResultsViewModel

    lateinit var result: Places

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState : Bundle?
    ): View? {
        return inflater.inflate(R.layout.results_fragment, container, false)
    }




    override fun onActivityCreated(savedInstanceState : Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ResultsViewModel::class.java)
        // TODO: Use the ViewModel
        if (result != null) {
            name.text = result.name
            address.text = result.formatted_address
            rating.text = result.rating.toString()
            if (result.open_now == false) {
                open.text = "Not open at the moment, Sorry."
            } else {
                open.text = "Currently open, go get some food!"
            }
            image.setImageURI(Uri.parse("https://maps.google.com/maps/contrib/111344714360374672989"))
        }
        btnBack.setOnClickListener {
            (activity as MainActivity).returnHome()

        }
        address.setOnClickListener{
            val browserIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com/search?q=" + result.formatted_address))
            startActivity(browserIntent)
        }

    }

}
