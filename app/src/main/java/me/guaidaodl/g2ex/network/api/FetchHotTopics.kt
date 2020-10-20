package me.guaidaodl.g2ex.network.api

import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import me.guaidaodl.g2ex.network.Tags.API_HOT
import me.guaidaodl.g2ex.network.data.RawTopic
import me.guaidaodl.mobile.common.ext.mapObject
import me.guaidaodl.mobile.common.utils.AppUtils
import me.guaidaodl.mobile.log.Log
import org.json.JSONArray
import org.json.JSONException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

private const val FETCH_HOT_TOPIC_URL = "https://www.v2ex.com/api/topics/hot.json"

/**
 * 获取 V2ex 的热门列表
 */
suspend fun fetchHotTopics(): List<RawTopic> = withContext(Dispatchers.IO) {
    suspendCoroutine { continuation ->
        val queue = Volley.newRequestQueue(AppUtils.appContext())
        val request = StringRequest(Request.Method.GET, FETCH_HOT_TOPIC_URL,
            {
                Log.i(API_HOT, it)
                continuation.resume(parseHotResponse(it))
            },
            {
                Log.i(API_HOT, "failed")
                continuation.resumeWithException(it)
            })
        queue.add(request)
    }
}

private fun parseHotResponse(response: String): List<RawTopic> {
    return try {
        JSONArray(response)
            .mapObject {
                RawTopic(
                    id = it.optLong("id", -1),
                    title= it.optString("title"),
                    url = it.optString("url"),
                    createdTimeInSecond = it.optInt("created", 0))
            }
    } catch (e: JSONException) {
        Log.e(API_HOT, "fetch failed", e)
        emptyList()
    }
}