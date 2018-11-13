package com.newolf.logutils

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.newolf.logutilslib.NLogUtls
import com.newolf.logutilslib.Utils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Utils.init(application)


        NLogUtls.getConfig().mLogSwitch = BuildConfig.DEBUG
        NLogUtls.e("this is Test")

        btnClick.setOnClickListener({ NLogUtls.e("This is NLogUtils's log ") })

    }
}
