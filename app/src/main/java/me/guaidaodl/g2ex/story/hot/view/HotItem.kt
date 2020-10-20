package me.guaidaodl.g2ex.story.hot.view

import androidx.compose.foundation.Text
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.ui.tooling.preview.Preview
import me.guaidaodl.g2ex.entity.TopicEntity
import me.guaidaodl.g2ex.story.hot.HotTopic
import me.guaidaodl.g2ex.ui.AppColor

@Preview
@Composable
fun ItemPreview() {
    Surface(color = Color.White) {
        HotTopicItem(
            topic = HotTopic(
                TopicEntity(
                    id = 1,
                    title = "买个惨, 找 V 友们诉苦",
                    url = "",
                    createdTime = System.currentTimeMillis()
                )
            )
        )
    }
}

@Composable
fun HotTopicItem(topic: HotTopic, onItemClick: ((HotTopic) -> Unit)? = null) {
    Column {
        Divider(Modifier.height(10.dp), color = AppColor.dividerColor)

        val itemModifier = Modifier
            .clickable(onClick = { onItemClick?.invoke(topic) })
            .fillMaxWidth()

        Column(modifier = itemModifier) {
            val horizontalPadding = 20.dp
            val titleModifier = Modifier
                .padding(top = 10.dp, start = horizontalPadding, end = horizontalPadding)
            Text(
                text = topic.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,

                maxLines = 2,
                color = AppColor.primaryTextColor,
                modifier = titleModifier
            )

            val createTimeModifier = Modifier
                .padding(top = 5.dp, bottom = 10.dp, end = horizontalPadding)
                .align(Alignment.End)
            Text(
                text = topic.createTime,
                color = AppColor.secondaryTextColor,
                modifier = createTimeModifier
            )
        }
    }
}
