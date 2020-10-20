package me.guaidaodl.g2ex.story.hot.model

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.guaidaodl.g2ex.entity.TopicEntity
import me.guaidaodl.g2ex.network.api.fetchHotTopics
import me.guaidaodl.g2ex.network.data.RawTopic

class HotRepository {
    suspend fun getHotTopics(): List<TopicEntity> = withContext(Dispatchers.IO) {
        fetchHotTopics().mapNotNull { it.toEntity() }
    }
}

private fun RawTopic.toEntity(): TopicEntity? {
    val id = this.id
    if (id <= 0) {
        return null
    }

    val title = this.title ?: return null
    val url = this.url ?: return null

    val time = this.createdTimeInSecond
    if (time <= 0) {
        return null
    }

    return TopicEntity(
        id = id,
        title = title,
        url = url,
        createdTime = time * 1000L)
}