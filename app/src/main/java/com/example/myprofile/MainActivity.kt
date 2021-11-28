package com.example.myprofile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.etebarian.meowbottomnavigation.MeowBottomNavigation.ClickListener
import com.etebarian.meowbottomnavigation.MeowBottomNavigation.ShowListener
import com.example.myprofile.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val ID_HOME = 1
    private val ID_MESSAGE = 2
    private val ID_NOTIFICATION = 3
    private val ID_ACCOUNT = 4
    private val ID_ADD = 5

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this@MainActivity))
        setContentView(binding.root)

        binding.imageViewUserProfile.setOnClickListener {
            val intent = Intent(this@MainActivity, TestActivity::class.java)
            startActivity(intent)
        }


       binding.bottomNavigation.add(MeowBottomNavigation.Model(ID_HOME, R.drawable.ic_bottom_nav_settings))
       binding.bottomNavigation.add(MeowBottomNavigation.Model(ID_MESSAGE, R.drawable.ic_bottom_nav_groups))
//       binding.bottomNavigation.add(MeowBottomNavigation.Model(ID_MESSAGE, R.drawable.ic_bottom_nav_add))
       binding.bottomNavigation.add(MeowBottomNavigation.Model(ID_NOTIFICATION, R.drawable.ic_bottom_nav_folder))
       binding.bottomNavigation.add(MeowBottomNavigation.Model(ID_ACCOUNT, R.drawable.ic_bottom_nav_home))

        binding.bottomNavigation.setOnClickMenuListener(ClickListener {
            Toast.makeText(
                this@MainActivity,
                "clicked item",
                Toast.LENGTH_SHORT
            ).show()
        })


        binding.bottomNavigation.setOnShowListener(ShowListener { item ->
            val name: String =
            when (item.id) {
                ID_HOME -> "Home"
                ID_MESSAGE -> "Message"
                ID_ADD -> "Add"
                ID_NOTIFICATION -> "Notification"
                ID_ACCOUNT -> "Account"
                else -> ""
            }
        })

        binding.bottomNavigation.setCount(ID_NOTIFICATION, "5")
        binding.bottomNavigation.show(ID_HOME, true)
    }
}