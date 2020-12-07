package com.example.hopeCopyOne


import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun openDatePicker(view: View) {

        var c: Calendar = Calendar.getInstance()

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view: DatePicker?, yy: Int, mm: Int, dd: Int ->
            var dt = "$dd/${mm}/$yy"
           TimePickerDialog(this,TimePickerDialog.OnTimeSetListener{view: TimePicker?, hh: Int, mm: Int ->
               dt += " $hh:$mm"

               editTextTextPersonName.setText(dt)
           },c.get(Calendar.HOUR),c.get(Calendar.MINUTE),false).show()
        },
        c.get(Calendar.YEAR),c.get(Calendar.MONTH),c.get(Calendar.DAY_OF_MONTH)).show()

    }

    fun CalculateAge(view: View) {

        var today  = Date()
        var dobs= editTextTextPersonName.text.toString()
        var sdf = SimpleDateFormat("dd/mm/yyy hh:MM")
        var dob = sdf.parse(dobs)
        var days =  (today.time - dob.time)/86400000
        var hours = (today.time - dob.time)%86400000/3600000
        var minutes = (today.time - dob.time)%86400000%3600000/60000
        var seconds = (today.time - dob.time)%86400000%3600000%60000/1000

        textView.visibility = View.VISIBLE
        textView.setText("Days = $days\nHours = $hours\nMinnutes = $minutes\nSeconds = $seconds")


    }
}


