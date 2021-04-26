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

        var y = 30
        var origin_x = 30
        for (i in 1..10)
        {
            println(origin_x)
            println(y)

            var onebutton = Button(this)
            onebutton.tag = i
            onebutton.text = i.toString()
            onelayout.addView(onebutton)

            val lp = onebutton.getLayoutParams() as ConstraintLayout.LayoutParams
            lp.height = 200
            lp.width = 200
            lp.topToTop = onelayout.top
            lp.leftToLeft = onelayout.left
            lp.topMargin = y
            lp.leftMargin = origin_x
            if (i == 10)
            {
                lp.leftMargin = origin_x + 230
                onebutton.tag = 0
                onebutton.text = "0"
            }
            onebutton.layoutParams = lp


            onebutton.setOnClickListener {
                println(onebutton.getTag())
            }

            if (i % 3 == 0)
            {
                origin_x = 30
                y += 230
            }
            else
            {
                origin_x += 230
            }
        }
    }
}