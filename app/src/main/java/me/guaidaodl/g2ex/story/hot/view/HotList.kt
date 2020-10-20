package me.guaidaodl.g2ex.story.hot.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.ui.tooling.preview.Preview
import me.guaidaodl.g2ex.entity.TopicEntity
import me.guaidaodl.g2ex.story.hot.HotTopic


@Composable
fun HotList(topics: LiveData<List<HotTopic>>, onItemClick: ((HotTopic) -> Unit)? = null) {
    val topicState = topics.observeAsState()
    LazyColumnFor(
        modifier = Modifier.fillMaxWidth(),
        items = topicState.value ?: emptyList()
    ) { topic ->
        HotTopicItem(topic, onItemClick)
    }
}


@Preview
@Composable
fun previewHotList() {
    val topics = MutableLiveData(
        listOf(
            HotTopic(
                TopicEntity(
                    id = 1,
                    title = "趁着新 iPhone 还没有发货, 讨论一下旧 iPhone 数据迁移的问题",
                    url = "",
                    createdTime = System.currentTimeMillis()
                )
            ),
            HotTopic(
                TopicEntity(
                    id = 1,
                    title = "坦格利安家族的风暴降生丹尼莉丝坦格利安一世、不焚者、弥林女王、安达尔人和先民的女王、七国统治者暨全境守护者、草原上的卡丽熙、打碎镣铐者以及龙之母！",
                    url = "",
                    createdTime = System.currentTimeMillis()
                )
            ),
            HotTopic(
                TopicEntity(
                    id = 1,
                    title = "test",
                    url = "",
                    createdTime = System.currentTimeMillis()
                )
            ),
            HotTopic(
                TopicEntity(
                    id = 1,
                    title = "test",
                    url = "",
                    createdTime = System.currentTimeMillis()
                )
            ),
            HotTopic(
                TopicEntity(
                    id = 1,
                    title = "test",
                    url = "",
                    createdTime = System.currentTimeMillis()
                )
            ),
            HotTopic(
                TopicEntity(
                    id = 1,
                    title = "test",
                    url = "",
                    createdTime = System.currentTimeMillis()
                )
            )
        )
    )
    Surface(color = Color.White) {
        HotList(topics)
    }
}


