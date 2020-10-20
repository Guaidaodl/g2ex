package me.guaidaodl.mobile.common.ext

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

/**
 * 遍历 JSONArray 中的 JSONObject
 *
 * @throws JSONException 格式错误是抛出
 */
inline fun JSONArray.forEachObject(visitor: (JSONObject) -> Unit) {
    for (i in 0 until length()) {
        visitor(getJSONObject(i))
    }
}

/**
 * JSONArray 中的 map 操作
 *
 * @throws JSONException 格式错误是抛出
 */
inline fun <T> JSONArray.mapObject(visitor: (JSONObject) -> T): List<T> {
    val list = mutableListOf<T>()
    for (i in 0 until length()) {
        list.add(visitor(getJSONObject(i)))
    }

    return list
}
