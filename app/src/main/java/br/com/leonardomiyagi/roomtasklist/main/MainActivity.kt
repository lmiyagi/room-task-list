package br.com.leonardomiyagi.roomtasklist.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import br.com.leonardomiyagi.roomtasklist.R
import br.com.leonardomiyagi.roomtasklist.base.BaseActivity
import br.com.leonardomiyagi.roomtasklist.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}
