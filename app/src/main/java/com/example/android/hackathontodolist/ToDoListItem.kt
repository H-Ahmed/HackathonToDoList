package com.example.android.hackathontodolist

import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel
import java.util.*

/**
 * Created by ahmed on 10/02/2018.
 */
@Table(name = "items", database = AppDatabase::class)
class ToDoListItem : BaseModel() {

    @PrimaryKey(autoincrement = true)
    var  id2=0;
    @Column
    var name:String = ""

    @Column
    var priority:Int =-1

    @Column
    var description:String=""

    @Column
    lateinit var date:Date

    fun insertData(name: String, priority: Int, description: String, date: Date) {
        this.name = name
        this.priority = priority
        this.description = description
        this.date = date

    }
}