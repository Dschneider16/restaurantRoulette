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
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import java.lang.Exception

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

        btnSearchGo.setOnClickListener{
            //message.text = "Searching..."
            //open search fragment
                    (activity as MainActivity).getResults(
                        fieldFood.text.toString(),
                        fieldPostalCode.text.toString()
                    )

        }

    }

}
