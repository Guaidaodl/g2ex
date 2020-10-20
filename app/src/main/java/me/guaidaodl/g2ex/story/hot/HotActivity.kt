package me.guaidaodl.g2ex.story.hot

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import me.guaidaodl.g2ex.base.ui.BaseActivity
import me.guaidaodl.g2ex.story.hot.view.HotList
import me.guaidaodl.g2ex.ui.G2EXTheme
import me.guaidaodl.mobile.log.Log

private const val TAG = "HotActivity"

/**
 * 用于显示热门列表的页面
 */
class HotActivity: BaseActivity() {

    val hotVm by viewModels<HotViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            G2EXTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    HotList(topics = hotVm.hotTopics,
                        onItemClick = { topic -> onClickTopic(topic)})
                }
            }
        }

        lifecycleScope.launch {
            hotVm.fetchHotTopics()
        }
    }

    private fun onClickTopic(topic: HotTopic) {
        Log.i(TAG, "click topic: ${topic.title}")
    }

    companion object {
        fun start(context: Context) {
            Log.i(TAG, "show hot")
            context.startActivity(Intent(context, HotActivity::class.java))
        }
    }
}

