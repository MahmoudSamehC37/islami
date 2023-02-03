package com.example.islami.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.islami.*
import com.example.islami.Fragments.HadethFragment
import com.example.islami.Fragments.QuranFragment
import com.example.islami.Fragments.RadioFragment
import com.example.islami.Fragments.SebhaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationView : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationView=findViewById(R.id.bottom_nav)
        bottomNavigationView.setOnItemSelectedListener(){
            if(it.itemId== R.id.quran){
                PushFragment(QuranFragment())
            }else if(it.itemId== R.id.hadeth){
                PushFragment(HadethFragment())
            }
            else if(it.itemId== R.id.radio){
                PushFragment(RadioFragment())
            }
            else if(it.itemId== R.id.sebha){
                PushFragment(SebhaFragment())
            }
            return@setOnItemSelectedListener true
        }
        bottomNavigationView.selectedItemId= R.id.quran
    }
    fun PushFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.continer_fragments,fragment)
            .commit()
    }
}