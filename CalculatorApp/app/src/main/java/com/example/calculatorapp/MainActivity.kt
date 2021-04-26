package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginLeft

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var onelayout = findViewById<ConstraintLayout>(R.id.testlayout)

        var onebutton = Button(this)

//        onebutton.setLeftTopRightBottom(100,100,100,100)
//        onebutton.top = 100
//        onebutton.width = 100
//        onebutton.height = 100
        onebutton.tag = 1
        onebutton.text = "1"
        onelayout.addView(onebutton)
        val lp = onebutton.getLayoutParams() as ConstraintLayout.LayoutParams
        lp.height = 300
        lp.width = 300
        lp.topToTop = onelayout.top
        lp.leftToLeft = onelayout.left
        lp.topMargin = 200
        lp.leftMargin = 200
        onebutton.setLayoutParams(lp)
        var y = 30
//        for (i in 1..10)
//        {
//            println(30 + (i - 1) * 100)
//            var onebutton = Button(this)
//            onebutton.left = 100
//            onebutton.setLeftTopRightBottom(30 + (i - 1) * 100,y,0,0)
//            onebutton.width = 100
//            onebutton.height = 100
//            onebutton.tag = i
//            onebutton.text = i.toString()
//            onelayout.addView(onebutton)
//            if (i % 3 == 0)
//            {
//
//                y += 130
//            }
//
//            onebutton.setOnClickListener {
//                println(onebutton.getTag())
//            }
//        }
    }
}