package com.example.android.hackathontodolist

import io.realm.RealmObject
import java.util.*

/**
 * Created by ahmed on 10/02/2018.
 */
class ToDoListItem : RealmObject(){

    var name:String = "";
    var priority:Int =-1;
    var description:String="";
    var date:String="";
    var time: Date? =null;

}