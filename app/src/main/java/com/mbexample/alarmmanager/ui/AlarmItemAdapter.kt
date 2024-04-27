package com.mbexample.alarmmanager.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mbexample.alarmmanager.data.sources.local.Alarm
import com.mbexample.alarmmanager.databinding.AlarmListItemBinding
import java.text.DateFormat

class AlarmItemAdapter: ListAdapter<Alarm, AlarmItemAdapter.HomeViewHolder>(diffCallBack) {

    inner class HomeViewHolder(private val binding: AlarmListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(alarm: Alarm) {
            binding.apply {
                tvTitle.isVisible = alarm.title.isNotBlank()
                tvDesc.isVisible = alarm.message.isNotBlank()
                tvTitle.text = alarm.title
                tvDesc.text = alarm.message
                val df: DateFormat = DateFormat.getTimeInstance()
                val formattedDate = df.format(alarm.scheduleAt)
                tvAlarmTime.text = formattedDate
            }
        }
    }

    companion object {
        val diffCallBack = object : DiffUtil.ItemCallback<Alarm>() {
            override fun areItemsTheSame(oldItem: Alarm, newItem: Alarm) =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Alarm, newItem: Alarm) =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder(
            AlarmListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

}


