package com.restaurantroulette

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.TextView
import com.restaurantroulette.ui.main.MainFragment
import com.restaurantroulette.ui.main.SearchFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }

    fun getResults(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, SearchFragment.newInstance())
            .commitNow()
    }
}
