package com.restaurantroulette.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.restaurantroulette.MainActivity
import com.restaurantroulette.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        btnRandom.setOnClickListener{
            viewModel.randomBool = !viewModel.randomBool
            if (viewModel.randomBool) {
                //call search function
                //message.text = "Generating Random Search Results..."

            }
            else {
                //Insert logic for changing back to question prompt.
                //message.text = "Random Searching Disabled, continue with the question prompt (CHANGE THIS)."
            }
        }

        btnSearchGo.setOnClickListener{
            //message.text = "Searching..."
            //open search fragment
            (activity as MainActivity).getResults()
        }
        // TODO: Use the ViewModel
    }

}
