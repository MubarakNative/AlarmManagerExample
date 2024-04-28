package com.mbexample.alarmmanager.alarmmanager

import com.mbexample.alarmmanager.data.sources.local.Alarm

interface AlarmScheduler {

    fun schedule(alarm: Alarm)
    fun cancel(alarm: Alarm)
}