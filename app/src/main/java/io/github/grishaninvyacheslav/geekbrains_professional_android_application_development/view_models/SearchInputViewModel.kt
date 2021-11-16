package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.App
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.R
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.SingleLiveEvent
import kotlinx.coroutines.*

class SearchInputViewModel : ViewModel() {
    private val liveMessage: SingleLiveEvent<AppState> = SingleLiveEvent()
    private val viewModelCoroutineScope = CoroutineScope(
        Dispatchers.Main
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        })

    private fun handleError(e: Throwable) {
        liveMessage.value = AppState.Error(e)
    }

    fun getData(query: String): LiveData<AppState> {
        viewModelCoroutineScope.launch {
            liveMessage.value = AppState.Loading
            if(submitQuery(query)){
                liveMessage.value = AppState.Success
            }
        }
        return liveMessage
    }

    // TODO: вынести в интерактор
    private fun submitQuery(query: String) =
        (!query.contains(" ") && query.isNotBlank()).apply {
            if (!this) {
                if (query.contains(" ")) {
                    throw Throwable(App.instance.getString(R.string.query_is_invalid_more_than_one_word))
                } else if (query.isBlank()) {
                    throw Throwable(App.instance.getString(R.string.query_is_invalid_more_than_no_word))
                }
            }
        }
}