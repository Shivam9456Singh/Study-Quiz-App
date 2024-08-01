package com.martinestudio.kidsapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.martinestudio.kidsapp.Fragment.HistoryFragment
import com.martinestudio.kidsapp.Fragment.HomeFragment
import com.martinestudio.kidsapp.Fragment.ProfileFragment
import com.martinestudio.kidsapp.Fragment.SpinFragment
import com.martinestudio.kidsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding : ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bottomNavigationView = binding.bottomNavigation
        bottomNavigationView.itemIconTintList = null

        setFrameLaout(HomeFragment())

        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.homeFragment -> setFrameLaout(HomeFragment())
                R.id.spinFragment -> setFrameLaout(SpinFragment())
                R.id.historyFragment -> setFrameLaout(HistoryFragment())
                R.id.profileFragment -> setFrameLaout(ProfileFragment())
                else ->{

                }
            }
            true
        }
    }

    private fun setFrameLaout(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment)
        fragmentTransaction.commit()
    }
}