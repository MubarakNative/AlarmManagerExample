package com.mbexample.alarmmanager.data.sources.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Alarm(

    @PrimaryKey(true)
    val id:Int,
    val title: String,
    val message: String,
    val scheduleAt:Long
)
