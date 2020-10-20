package me.guaidaodl.g2ex.entity

data class TopicEntity(
    /**
     * 话题的 ID
     */
    val id: Long,
    /**
     * 话题的标题
     */
    val title: String,

    /**
     * 话题的地址
     */
    val url: String,

    /**
     * 话题创建的时间
     */
    val createdTime: Long
)