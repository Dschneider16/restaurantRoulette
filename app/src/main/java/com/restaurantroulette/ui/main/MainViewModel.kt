package com.restaurantroulette.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    internal fun getRandomBool(): Boolean {
        return Math.random() >= 0.5
    }
}
