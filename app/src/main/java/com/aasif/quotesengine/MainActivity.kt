package com.aasif.quotesengine

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.aasif.quotesengine.databinding.ActivityMainBinding
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var quoteAdapter: QuotesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setAdapter()
        setContentView(binding.root)
    }

    private fun setAdapter() {
        val quotes: MutableList<String> = ArrayList()
        quotes.addAll(
            setOf(
                "Only I can change my life. No one can do it for me.",
                "Life is 10% what happens to you and 90% how you react to it.",
                "With the new day comes new strength and new thoughts.\n",
                "Change your life today. Don't gamble on the future, act now, without delay.\n",
                "Change your life today. Don't gamble on the future, act now, without delay.",
                "Failure will never overtake me if my determination to succeed is strong enough.",
                "The past cannot be changed. The future is yet in your power.",
                "Infuse your life with action. Don't wait for it to happen. Make it happen.",
                "Make your own future. Make your own hope. Make your own love.",
                "It does not matter how slowly you go as long as you do not stop.",
                "Well done is better than well said.",
                "It always seems impossible until it's done.",
                "Your talent is God's gift to you. What you do with it is your gift back to God.",
                "Always do your best. What you plant now, you will harvest later.",
                "Quality is not an act, it is a habit.",
            )
        )
        quoteAdapter = QuotesAdapter(quotes)
        binding.quoteList.apply {
            adapter = quoteAdapter
            hasFixedSize()
        }

    }

    private fun getQuotes(): List<String> {
        val quotes: MutableList<String> = ArrayList()
        var reader: BufferedReader? = null
        try {
            reader = BufferedReader(InputStreamReader(assets.open("quotes.txt"), "UTF-8"))
            var line: String
            while (reader.readLine().also { line = it } != null) {
                quotes.add(line)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            if (reader != null) {
                try {
                    reader.close()
                } catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        return quotes
    }
}