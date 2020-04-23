package com.restaurantroulette

import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat
import com.google.android.gms.maps.GoogleMap
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.restaurantroulette.dao.iPlacesDAO
import com.restaurantroulette.dto.Places
import com.restaurantroulette.ui.main.MainFragment
import com.restaurantroulette.ui.main.ResultsFragment
import kotlinx.android.synthetic.main.main_fragment.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var detector: GestureDetectorCompat
    val mainFragment: MainFragment = MainFragment.newInstance()
    var swipeDirectionReceived: SwipeDirection? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, mainFragment)
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

    fun getResults(food: String, postalCode: String){

        var resultsFragment: ResultsFragment = ResultsFragment.newInstance()
        var gson = Gson()
        //var response = placeService.fetchPlace(input)
        var call: Call<JsonObject>? = RetrofitClientInstance.retrofitInstance?.create(iPlacesDAO::class.java)?.getPlacesResults("$food near $postalCode", "textquery", "photos,formatted_address,name,opening_hours,rating", null, "AIzaSyDRWf-bSt6GMqPH5MWIpxF3EIDr9r_InRY")

        println("Request: \n" + call)
        var _place = JsonObject()
        call?.enqueue(object: Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                println("We failed to get the places \n" + t)
            }

            override fun onResponse(
                call: Call<JsonObject>,
                response: Response<JsonObject>
            ) {
                _place = response.body()!!
                try{
                if (_place != null) {
                    resultsFragment.result = gson.fromJson(
                        _place["candidates"].toString().drop(1).dropLast(1),
                        Places::class.java
                    )
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, resultsFragment)
                        .commitNow()
                    println("RESULTS SHOULD BE HERE: " + resultsFragment.result)
                }
                else {
                    println("Didn't get results " + _place)
                }
                }
                catch (e: Exception) {
                    println("Exception occured (Did you set the RR_API_KEY env var?): " + e)
                }
            }
        })

        //resultsFragment.result = gson.fromJson(this!!.result!!["candidates"], Places::class.java)
        //println(resultsFragment.result.toString())



        //println(URL("https://maps.googleapis.com/maps/api/place/findplacefromtext/json?input=mongolian%20grill&inputtype=textquery&fields=photos,formatted_address,name,opening_hours,rating&locationbias=circle:2000@47.6918452,-122.2226413&key=AIzaSyDRWf-bSt6GMqPH5MWIpxF3EIDr9r_InRY").readText())
        //set map coords
    }

    enum class SwipeDirection {
        UP, DOWN, LEFT, RIGHT
    }

    fun returnHome(){

            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
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
        swipeDirectionReceived = SwipeDirection.DOWN
        println(swipeDirectionReceived)
    }

    private fun onSwipeTop() {
        Toast.makeText(this, "top Swipe", Toast.LENGTH_LONG ).show()
        swipeDirectionReceived = SwipeDirection.UP
        println(swipeDirectionReceived)
    }

    private fun onSwipeLeft() {
        Toast.makeText(this, "left Swipe", Toast.LENGTH_LONG ).show()
        swipeDirectionReceived= SwipeDirection.LEFT
        println(swipeDirectionReceived)
    }

    private fun onSwipeRight() {
        swipeDirectionReceived = SwipeDirection.RIGHT
        println(swipeDirectionReceived)

        /**getResults(
            fieldFood.text.toString(),
            fieldPostalCode.text.toString()
        )**/

    }
}
