package edu.miu.cs473.cvbuilder

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URI
import java.net.URL

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);
        val pageAdapter = TabLayoutAdapter(this)
        tablayoutPager.adapter = pageAdapter
        tablayout.tabGravity = TabLayout.GRAVITY_FILL

        TabLayoutMediator(tablayout, tablayoutPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "HOME"
                }
                1 -> {
                    tab.text = "ABOUT ME"
                }
                2 -> {
                    tab.text = "WORK"
                }
                3 -> {
                    tab.text = "CONTACT"
                }
                else -> {

                }
            }
        }.attach()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.telegram_menu_item -> {
                val telegramURL = "tg://resolve?domain=k6sandeep"
                openUrl(telegramURL)
            }
            R.id.linkedin_menu_item -> {
                val linkedInURL = "https://www.linkedin.com/in/sandeepkoirala"
                openUrl(linkedInURL)
            }
            R.id.whatsapp_menu_item -> {
                val whatsAppURL = "https://api.whatsapp.com/send?phone=+358505938096"
                openUrl(whatsAppURL)
            }
            R.id.gmail_menu_item -> {
                val gmailAddress = "sndpkrl007@gmail.com"
                sendEmail(gmailAddress)
            }
            else -> {}
        }
        return true
    }
}