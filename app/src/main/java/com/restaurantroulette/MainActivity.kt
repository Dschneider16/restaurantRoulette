package com.restaurantroulette

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.TextView
import com.restaurantroulette.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
        val btnRandom = findViewById<Button>(R.id.btnRadom)
        val msgMain = findViewById<TextView>(R.id.message)
        btnRandom?.setOnClickListener{
            btnRandomClick(msgMain)
        }

    }

    /**
     * Logic for Selecting a random Restaraunt Location.
     * @param msg TextView of Main Fragment.
     */
    fun btnRandomClick(msg: TextView){
        msg.text = "Random selection enabled, hit search to continue."
        println("${msg.text}")
    }
}
