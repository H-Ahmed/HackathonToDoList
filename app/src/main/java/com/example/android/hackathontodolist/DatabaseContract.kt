package com.example.android.hackathontodolist

import com.example.android.hackathontodolist.DatabaseContract.NoteTable.DISCRIPTION
import com.example.android.hackathontodolist.DatabaseContract.NoteTable.PERIORITY
import com.example.android.hackathontodolist.DatabaseContract.NoteTable.TIME
import com.example.android.hackathontodolist.DatabaseContract.NoteTable.TITLE
import com.example.android.hackathontodolist.DatabaseContract.NoteTable._ID2
import com.example.android.hackathontodolist.DatabaseContract.NoteTable._TABLE_NAME

/**
 * Created by Hesham on 2/10/2018.
 */
object DatabaseContract {

    object NoteTable {
        val _ID2 = "_id"
        val PERIORITY = "1"
        val _TABLE_NAME = "notes"
        val TITLE = "text"
        val DISCRIPTION = "is_pinned"
        val TIME = "created_at"
    }

    val SQL_CREATE_ENTRIES = """CREATE TABLE $_TABLE_NAME (
         $_ID2 INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
         $PERIORITY INTEGER,
         $TITLE TEXT,
         $DISCRIPTION TEXT,
         $TIME DATE)"""

    val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS " + _TABLE_NAME

    val SQL_QUERY_ALL =
            "SELECT * FROM $_TABLE_NAME ORDER BY $PERIORITY DESC"


}