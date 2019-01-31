package com.nawstuff.cahyadi.clubmatch2.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*


class FavoriteDBHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "FavoriteFootball.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db?.createTable(
            FavoriteParamsDB.TABLE_FAVORITE, true,
            FavoriteParamsDB.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            FavoriteParamsDB.EVENT_ID to TEXT + UNIQUE,
            FavoriteParamsDB.EVENT_TIME to TEXT,
            FavoriteParamsDB.HOME_TEAM to TEXT,
            FavoriteParamsDB.HOME_SCORE to TEXT,
            FavoriteParamsDB.AWAY_TEAM to TEXT,
            FavoriteParamsDB.AWAY_SCORE to TEXT,
            FavoriteParamsDB.HOME_TEAM_ID to TEXT,
            FavoriteParamsDB.AWAY_TEAM_ID to TEXT
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.dropTable(FavoriteParamsDB.TABLE_FAVORITE, true)
    }

    companion object {
        private var instance: FavoriteDBHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): FavoriteDBHelper {
            if (instance == null) {
                instance = FavoriteDBHelper(ctx.applicationContext)
            }
            return instance as FavoriteDBHelper
        }
    }


}