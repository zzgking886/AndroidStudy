package com.example.calculatorapp

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginLeft
import java.lang.Exception

var onenum1 = ""
var onenum2 = ""
var onerule = ""
var oneresult = ""

class MainActivity : AppCompatActivity(){

    var resultText : TextView? = null

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var onelayout = findViewById<ConstraintLayout>(R.id.testlayout)

        var y = 30
        var origin_x = 30
        for (i in 1..10)
        {
            var onebutton = Button(this)
            onelayout.addView(onebutton)
            onebutton.text = i.toString()

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
                onebutton.text = "0"

                var resultbutton = Button(this)
                resultbutton.text = "="
                onelayout.addView(resultbutton)
                val reslp = resultbutton.getLayoutParams() as ConstraintLayout.LayoutParams
                reslp.height = 200
                reslp.width = 200
                reslp.topToTop = onelayout.top
                reslp.leftToLeft = onelayout.left
                reslp.topMargin = y
                reslp.leftMargin = origin_x + 460
                resultbutton.setOnClickListener {
                    getResultFunction()
                }

                var clearbutton = Button(this)
                clearbutton.text = "C"
                onelayout.addView(clearbutton)
                val cp = clearbutton.getLayoutParams() as ConstraintLayout.LayoutParams
                cp.height = 200
                cp.width = 200
                cp.topToTop = onelayout.top
                cp.leftToLeft = onelayout.left
                cp.topMargin = y
                cp.leftMargin = origin_x
                clearbutton.setOnClickListener {
                    resultText!!.text = "0"
                    onenum1 = ""
                    onenum2 = ""
                    oneresult = ""
                }
            }
            onebutton.layoutParams = lp


            onebutton.setOnClickListener {
                println(onebutton.text)
                inputParams(onebutton.text as String)
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

        var onrgin_ry = 30
        for (i in 1..4)
        {
            var rulebutton = Button(this)
            rulebutton.text = ""
            when (i)
            {
                1 -> rulebutton.text = "+"
                2 -> rulebutton.text = "-"
                3 -> rulebutton.text = "*"
                4 -> rulebutton.text = "/"
            }
            onelayout.addView(rulebutton)
            val rlp = rulebutton.getLayoutParams() as ConstraintLayout.LayoutParams
            rlp.height = 200
            rlp.width = 200
            rlp.topToTop = onelayout.top
            rlp.leftToLeft = onelayout.left
            rlp.topMargin = onrgin_ry
            rlp.leftMargin = 720
            rulebutton.setOnClickListener {
                inputParams(rulebutton.text as String)
            }

            onrgin_ry +=230
        }

        resultText = TextView(this)
        onelayout.addView(resultText)
        resultText!!.text = "0"
        resultText!!.setBackgroundColor(R.color.black)
        val rescp = resultText!!.getLayoutParams() as ConstraintLayout.LayoutParams
        rescp.height = 50
        rescp.width = 300
        rescp.topToTop = onelayout.top
        rescp.leftToLeft = onelayout.left
        rescp.topMargin = 950
        rescp.leftMargin = 30
    }

    fun inputParams(param:String)
    {

        if ((onenum1 == "") && (onenum2 == ""))
        {
            if (param == "+" || param == "-" || param == "*" || param == "/")
            {
                Toast.makeText(this,"请输入计算数字",Toast.LENGTH_SHORT).show()
                return
            }
            onenum1 = param
            resultText!!.text = onenum1
        }
        else
        {
            if (param == "+" || param == "-" || param == "*" || param == "/")
            {
                onerule = param
                if (onenum1.isNotEmpty() && onenum2.isNotEmpty())
                {
                    onenum1 = resultText!!.text as String
                    onenum2 = ""
                }
            }
            else
            {
                if (onenum2 == "")
                    onenum2 = param
                resultText!!.text = onenum2
            }
        }
    }


    fun getResultFunction()
    {
        if (onenum1.isNotEmpty() && onenum2.isNotEmpty())
        {
            if (onerule == "+")
            {
                oneresult = ""
                oneresult = (onenum1.toInt() + onenum2.toInt()).toString()
            }
            else if (onerule == "-")
            {
                oneresult = ""
                oneresult = (onenum1.toInt() - onenum2.toInt()).toString()
            }
            else if (onerule == "*")
            {
                oneresult = ""
                oneresult = (onenum1.toInt() * onenum2.toInt()).toString()
            }
            else if (onerule == "/")
            {
                oneresult = ""
                if (onenum2 == "0")
                {
                    Toast.makeText(this,"除数不为0",Toast.LENGTH_SHORT).show()
                    return
                }
                oneresult = (onenum1.toInt() / onenum2.toInt()).toString()
            }
            else
            {
                return
            }
            resultText!!.text = oneresult.toString()
        }
    }
}