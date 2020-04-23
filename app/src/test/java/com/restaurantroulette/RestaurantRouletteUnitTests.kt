package com.restaurantroulette

import android.os.SystemClock
import android.view.MotionEvent
import com.google.gson.JsonArray
import com.restaurantroulette.dto.Places
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class RestaurantRouletteUnitTests() {

    var ma = Robolectric.buildActivity(MainActivity::class.java).create().get()

    lateinit var testDownEvent: MotionEvent
    lateinit var testMoveEvent: MotionEvent
    lateinit var food: String
    lateinit var postalCode: String
    var input = ""
    var places = Places(null, null, null, null, null)
    val diaryGestureListener = ma.DiaryGestureListener()

    @Before
    fun setUp() {

    }

    @Test
    fun mapPlacesObject() {
        places.formatted_address = "address"
        places.name = "name"
        places.open_now = true
        places.photos = JsonArray()
        places.rating = 5.0f
        assertEquals(places.formatted_address, "address")
        assertEquals(places.name, "name")
        assertEquals(places.open_now, true)
        assertEquals(places.photos, JsonArray())
        assertEquals(places.rating, 5.0f)
    }

    @Test
    fun searchByZipCode_returnsResultWithZipCode() {
        givenInputIsPresent()
        whenSearchByZipCode()
        thenResultAddressContainsZipCode()
    }

    private fun givenInputIsPresent() {
        food = "chinese"
        postalCode = "45150"
        assertNotNull(ma.getResults(food, postalCode))
    }

    private fun whenSearchByZipCode() {
        input.contains(postalCode)
    }

    private fun thenResultAddressContainsZipCode() {
        places.formatted_address?.contains(postalCode)
    }

    @Test
    fun testSwipeRight() {
        testDownEvent = MotionEvent.obtain(250, SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, 110f, 50f, 0)
        testMoveEvent = MotionEvent.obtain(250, SystemClock.uptimeMillis(), MotionEvent.ACTION_MOVE, 250f, 50f, 0)
        diaryGestureListener.onFling(testDownEvent, testMoveEvent, velocityX = 150f, velocityY = 0f)
        assertEquals(ma.swipeDirectionReceived.toString(), "RIGHT")
    }

    @Test
    fun testSwipeLeft() {
        testDownEvent = MotionEvent.obtain(250, SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, 250f, 50f, 0)
        testMoveEvent = MotionEvent.obtain(250, SystemClock.uptimeMillis(), MotionEvent.ACTION_MOVE, 110f, 50f, 0)
        diaryGestureListener.onFling(testDownEvent, testMoveEvent, velocityX = 150f, velocityY = 0f)
        assertEquals(ma.swipeDirectionReceived.toString(), "LEFT")
    }

    @Test
    fun testSwipeDown() {
        testDownEvent = MotionEvent.obtain(250, SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, 50f, 250f, 0)
        testMoveEvent = MotionEvent.obtain(250, SystemClock.uptimeMillis(), MotionEvent.ACTION_MOVE, 50f, 110f, 0)
        diaryGestureListener.onFling(testDownEvent, testMoveEvent, velocityX = 0f, velocityY = 1500f)
        assertEquals(ma.swipeDirectionReceived.toString(), "DOWN")
    }

    @Test
    fun testSwipeUp() {
        testDownEvent = MotionEvent.obtain(250, SystemClock.uptimeMillis(), MotionEvent.ACTION_DOWN, 50f, 110f, 0)
        testMoveEvent = MotionEvent.obtain(250, SystemClock.uptimeMillis(), MotionEvent.ACTION_MOVE, 50f,250f, 0)
        diaryGestureListener.onFling(testDownEvent, testMoveEvent, velocityX = 0f, velocityY = 150f)
        assertEquals(ma.swipeDirectionReceived.toString(), "UP")
    }

}