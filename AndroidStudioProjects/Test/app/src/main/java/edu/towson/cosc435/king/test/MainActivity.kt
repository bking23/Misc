package edu.towson.cosc435.king.test

import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import java.lang.Double.parseDouble
import java.lang.Integer.parseInt

import java.net.URL
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {
    val CITY: String = "Baltimore"
    val API: String = "aa6bbd2aa9c07466e75952a9698f2da4"
    private lateinit var getUserLocationBtn: Button
    private lateinit var getUserLocation: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        getUserLocationBtn = findViewById(R.id.location_btn)
        getUserLocationBtn.setOnClickListener {
            weatherTask().execute()
        }

    }
    fun getUserInput(): String {
        getUserLocation = findViewById(R.id.getUserLocation_et)
        return getUserLocation.getText().toString()
    }
    inner class weatherTask() : AsyncTask<String, Void, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            /* Showing the ProgressBar, Making the main design GONE */
            findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.VISIBLE
            findViewById<TextView>(R.id.errorText).visibility = View.GONE
        }
        override fun doInBackground(vararg params: String?): String? {
            var response:String?
            try{
                response = URL("https://api.openweathermap.org/data/2.5/weather?q=${getUserInput()}&units=metric&appid=$API").readText(
                        Charsets.UTF_8
                )
            }catch (e: Exception){
                response = null
            }
            return response
        }
        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try {
                /* Extracting JSON returns from the API */
                val jsonObj = JSONObject(result)
                val main = jsonObj.getJSONObject("main")
                val sys = jsonObj.getJSONObject("sys")
                val weather = jsonObj.getJSONArray("weather").getJSONObject(0)
                var temp = main.getString("temp")
                var newTemp = parseDouble(temp)
                newTemp = ((newTemp * 1.8) + 32)
                val humidity = main.getString("humidity")
                val weatherDescription = weather.getString("description")
                val address = jsonObj.getString("name")+", "+sys.getString("country")
                /* Populating extracted data into our views */
                findViewById<TextView>(R.id.address).text = "Entered Location: " + address
                findViewById<TextView>(R.id.status).text = "Weather Description: " + weatherDescription.capitalize()
                findViewById<TextView>(R.id.temp).text = "Temp: " + newTemp.roundToLong().toString()+"°F"
                findViewById<TextView>(R.id.humidity1).text = "Current Humidity: " + humidity
                /* Views populated, Hiding the loader, Showing the main design */
                findViewById<RelativeLayout>(R.id.mainContainer).visibility = View.VISIBLE
            } catch (e: Exception) {
                findViewById<TextView>(R.id.errorText).visibility = View.VISIBLE
            }
        }
    }
}