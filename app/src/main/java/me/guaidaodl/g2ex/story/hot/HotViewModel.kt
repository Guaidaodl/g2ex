package me.guaidaodl.g2ex.story.hot

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import me.guaidaodl.g2ex.story.hot.model.HotRepository

class HotViewModel : ViewModel() {
    private val repository = HotRepository()
    private val _hotTopics = MutableLiveData<List<HotTopic>>(emptyList())
    val hotTopics: LiveData<List<HotTopic>> = _hotTopics

    fun fetchHotTopics() {
        viewModelScope.launch {
            try {
                val topics = repository.getHotTopics()
                _hotTopics.value = topics.map { HotTopic(entity = it) }
            } catch (ignore: Exception) {
            }
        }
    }
}