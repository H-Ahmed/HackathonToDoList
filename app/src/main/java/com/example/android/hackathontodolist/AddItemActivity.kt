package com.example.android.hackathontodolist

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils
import android.widget.TimePicker
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_add_item.*
import kotlinx.android.synthetic.main.content_add_item.*
import org.jetbrains.anko.design.snackbar
import java.util.*


class AddItemActivity : AppCompatActivity(), TimePickerDialog.OnTimeSetListener {
    val cal = Calendar.getInstance()
    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        cal.set(Calendar.HOUR_OF_DAY, p1)
        cal.set(Calendar.MINUTE, p2)

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_item)
        setSupportActionBar(toolbar)
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val hour = c.get(Calendar.HOUR_OF_DAY)
        val min = c.get(Calendar.MINUTE)


        var dateDialog = DatePickerDialog(
                this, null, year, month, day)

        var timeDialog = TimePickerDialog(
                this, this, hour, min, true)
        addBtn.setOnClickListener({
            val title = title_txt.text.toString().trim()
            val desc = descTxt.text.toString().trim()
            val priority = getPriority()
            val place = placeTxt.text.toString().trim()

            if (TextUtils.isEmpty(title)) {
                title_txt.error = getString(R.string.field_req)
                title_txt.requestFocus()
            }
             else if (TextUtils.isEmpty(desc)) {
                descTxt.error = getString(R.string.field_req)
                descTxt.requestFocus()
            } else if (TextUtils.isEmpty(place)) {
                placeTxt.error = getString(R.string.field_req)
                placeTxt.requestFocus()
            } else if (priority == -1) {
                snackbar(container, R.string.field_req)
            } else {
                val date = GregorianCalendar(dateDialog.datePicker.year
                        , dateDialog.datePicker.month, dateDialog.datePicker.dayOfMonth,
                        cal.get(Calendar.HOUR), cal.get(Calendar.MINUTE));
                val item = ToDoListItem();
                item.insertData(title, priority, desc, date.time)

                var isLogin = false
                if (isLogin)
                    saveToFirebase(item)
                else
                    saveToLocalDataBase(item)
                finish();
            }
        })
    }

    fun saveToLocalDataBase(item: ToDoListItem) {
        item.save();
    }

    fun getPriority(): Int {
        if (HighRadio.isChecked)
            return 1
        else if (MediumRadio.isChecked)
            return 2
        else if (LowRadio.isChecked)
            return 3
        else
            return -1
    }

    fun saveToFirebase(item: ToDoListItem) {
        val db = FirebaseDatabase.getInstance().getReference("ToDoListItem")
        val key = db.push().key
        db.child(key).setValue(item).addOnCompleteListener({ task ->
            if (task.isSuccessful) {
                Snackbar.make(container, getString(R.string.saved_msg), Snackbar.LENGTH_SHORT).show()
                saveToLocalDataBase(item)

            } else {

                Snackbar.make(container, getString(R.string.error_msg), Snackbar.LENGTH_SHORT).show()

            }
        })

    }
}

