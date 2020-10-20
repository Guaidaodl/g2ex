package me.guaidaodl.g2ex.network.data

/**
 * 从服务器获取的原始话题信息.
 */
class RawTopic(
    val id: Long = 0,
    val title: String?,
    val url: String?,
    /**
     * 话题的创建时间, 注意这里的单位秒而不是毫秒
     */
    val createdTimeInSecond: Int = 0)