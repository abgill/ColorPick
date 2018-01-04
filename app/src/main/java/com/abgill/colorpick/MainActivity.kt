package com.abgill.colorpick

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    val bgColor:Int = 0xFFFFFF

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        redSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                //setColor(calcColor())
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                setColor(calcColor())
            }

        })



        blueSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            internal var progressChangedValue = 0

            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                //setColor(calcColor())
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // TODO Auto-generated method stub
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                setColor(calcColor())
            }
        })

        greenSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                //setColor(calcColor())
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
                setColor(calcColor())
            }

        })



    }

    private fun calcColor() : String{
        var colorInt = redSeekBar.progress
        colorInt = colorInt.shl(8)
        colorInt = colorInt.or(greenSeekBar.progress)
        colorInt = colorInt.shl(8)
        colorInt = colorInt.or(blueSeekBar.progress)

        return "#${colorInt.toString(16).padStart(6, '0')}"
    }

    private fun setColor(color : String){

        try {
            val colorInt = Color.parseColor(color)

            colorView.setBackgroundColor(colorInt)

            hexCode.text = color
        }catch (e: IllegalArgumentException){
            e.printStackTrace()
        }
    }
}
