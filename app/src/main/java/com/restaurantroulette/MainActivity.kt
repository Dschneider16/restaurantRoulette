package com.restaurantroulette

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.GestureDetectorCompat
import androidx.lifecycle.ViewModelProviders
import com.restaurantroulette.ui.main.MainFragment
import com.restaurantroulette.ui.main.SearchFragment
import kotlinx.android.synthetic.main.main_fragment.*

class MainActivity : AppCompatActivity() {

    private lateinit var detector: GestureDetectorCompat


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()


        }
        detector = GestureDetectorCompat (this, DiaryGestureListener())
    }





    override fun onTouchEvent(event: MotionEvent?): Boolean {
       return if (detector.onTouchEvent(event)){
            true
        }else{
            return super.onTouchEvent(event)
        }

    }

    fun getResults(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, SearchFragment.newInstance())
            .commitNow()
    }
    inner class DiaryGestureListener: GestureDetector.SimpleOnGestureListener(){

        private val SWIPE_THRESHOLD = 100
        private val SWIPE_VELOCITY_THRESHOLD = 100


        override fun onFling(
            downEvent: MotionEvent?,
            moveEvent: MotionEvent?,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            val diffx = moveEvent?.x?.minus(downEvent!!.x) ?: 0.0f

            val diffy = moveEvent?.y?.minus(downEvent!!.y) ?: 0.0f

            return if (Math.abs(diffx) > Math.abs(diffy)){
                //left or right swipe
            if  (Math.abs(diffx) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD){
                if (diffx > 0){
                    //right swipe
                    this@MainActivity.onSwipeRight()

                }else{
                    //left swipe
                    this@MainActivity.onSwipeLeft()

                }
                true
            }else{
                super.onFling(downEvent, moveEvent, velocityX, velocityY)
            }


            }
            else{
                //bottom or top swipe
                if  (Math.abs(diffy) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD){
                    if (diffy > 0){
                        //top
                        this@MainActivity.onSwipeTop()

                    }else{
                        //bottom swipe
                        this@MainActivity.onSwipeBottom()

                    }

                    true
                }else{
                    super.onFling(downEvent, moveEvent, velocityX, velocityY)
                }

            }



        }
    }

    private fun onSwipeBottom() {
        Toast.makeText(this, "bottom Swipe", Toast.LENGTH_LONG ).show()
    }

    private fun onSwipeTop() {
        Toast.makeText(this, "top Swipe", Toast.LENGTH_LONG ).show()
    }

    private fun onSwipeLeft() {
        Toast.makeText(this, "left Swipe", Toast.LENGTH_LONG ).show()
    }

    private fun onSwipeRight() {

            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ResultsFragment.newInstance())
                .commitNow()


    }
}
