package com.example.android.hackathontodolist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = ListAdaptor(this)

    }

    override fun onResume() {
        super.onResume()
        (recycler.adapter as ListAdaptor)
    }

    public override fun onDestroy() {
        super.onDestroy()
    }
}
