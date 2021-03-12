package com.foreach.android.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.foreach.android.R
import com.foreach.android.base.utils.extension.addFragment
import com.foreach.android.fragment.SettingsFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.addFragment(R.id.frame,SettingsFragment.newInstance())
    }
}