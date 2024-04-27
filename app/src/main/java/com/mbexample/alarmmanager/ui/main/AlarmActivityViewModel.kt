package com.mbexample.alarmmanager.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.mbexample.alarmmanager.data.repository.AlarmRepository
import com.mbexample.alarmmanager.data.sources.local.Alarm
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlarmActivityViewModel @Inject constructor(
    private val alarmRepository: AlarmRepository
):ViewModel() {

    fun insertAlarm(alarm: Alarm)= viewModelScope.launch{
        alarmRepository.insertAlarm(alarm)
    }

    val getAllAlarm = alarmRepository.getAllAlarm().asLiveData()
}