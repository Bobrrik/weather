package com.example.qwest_1.data.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DataBaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null,
    DATABASE_VERSION
){


    override fun onCreate(db: SQLiteDatabase?) {

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    companion object {
        private const val DATABASE_NAME = "films.db"        //Название самой БД
        private const val DATABASE_VERSION = 1       //Версия БД

        //Константы для работы с таблицей
        const val TABLE_NAME = "films_table"

        const val COLUMN_ID = "id"
        const val COLUMN_TITLE = "city_name"
        const val COLUMN_POSTER = "populism"
    }
}
