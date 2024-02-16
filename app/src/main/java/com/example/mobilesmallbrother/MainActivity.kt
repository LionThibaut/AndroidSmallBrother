package com.example.mobilesmallbrother

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment

import com.example.mobilesmallbrother.fragments.FeedFragment
import com.example.mobilesmallbrother.fragments.LoginFragment
import com.example.mobilesmallbrother.fragments.ProfileFragment
import com.example.mobilesmallbrother.databinding.ActivityMainBinding
import com.example.mobilesmallbrother.dtos.DtoInputClient
import com.example.mobilesmallbrother.repositories.AnimalRepository
import com.google.android.material.bottomnavigation.BottomNavigationView
import org.w3c.dom.Text


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val profileFragment = ProfileFragment.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)

        /* supportFragmentManager
            .beginTransaction()
            .add(
                R.id.fl_mainActivity_fragmentContainer,
                LoginFragment.newInstance {
                    changeFragmentViewByLogin(it)
                },
                "loginFragment")
            .commit() */
        loadFragment(FeedFragment(), R.string.title_activity_disparitions_feed)

        val navigationView = findViewById<BottomNavigationView>(R.id.nv_mainActivity_navigation)
        navigationView.setOnNavigationItemSelectedListener{
            when (it.itemId) {
                R.id.login_page-> {
                    loadFragment(LoginFragment(), R.string.title_activity_login)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.feed_page-> {
                    loadFragment(FeedFragment(), R.string.title_activity_disparitions_feed)
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.profile_page-> {
                    loadFragment(ProfileFragment(), R.string.title_activity_my_aniamls)
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
        setContentView(binding.root)
    }

    private fun loadFragment(fragment: Fragment, string: Int){

        findViewById<TextView>(R.id.tv_mainActivity_pageTitle).text = resources.getString(string)


        //Test d'injection du login
        val injection = supportFragmentManager.beginTransaction()
        injection.replace(R.id.fl_mainActivity_fragmentContainer, fragment)
        injection.addToBackStack(null)
        injection.commit()
    }

     private fun changeFragmentViewByLogin(dtoClient: DtoInputClient) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_mainActivity_fragmentContainer, profileFragment)
            .commit()

        profileFragment.dtoClient = dtoClient
    }
}