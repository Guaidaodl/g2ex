package me.guaidaodl.g2ex.story.hot

import me.guaidaodl.g2ex.entity.TopicEntity
import java.text.SimpleDateFormat
import java.util.*

class HotTopic(private val entity: TopicEntity) {
    val title get() = entity.title

    val url get() = entity.url

    val createTime: String by lazy {
        val calender = Calendar.getInstance()
        calender.timeInMillis = entity.createdTime

        val format = SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault())
        format.format(calender.time)
    }
}