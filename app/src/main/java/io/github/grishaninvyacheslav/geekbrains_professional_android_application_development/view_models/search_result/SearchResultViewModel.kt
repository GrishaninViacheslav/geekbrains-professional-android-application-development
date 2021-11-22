package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models.search_result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.models.repository.DictionaryRepository
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.models.repository.IDictionaryRepository
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.ApiHolder
import kotlinx.coroutines.*

class SearchResultViewModel : ViewModel() {
    private val liveDefinitions: MutableLiveData<DefinitionsState> = MutableLiveData()
    private val repository: IDictionaryRepository = DictionaryRepository(ApiHolder.api)
    private val viewModelCoroutineScope = CoroutineScope(
        Dispatchers.Main
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        })

    private fun handleError(error: Throwable) {
        error.printStackTrace()
        liveDefinitions.value = DefinitionsState.Error(error)
    }

    fun getDefinitions(query: String): LiveData<DefinitionsState> {
        viewModelCoroutineScope.launch {
            liveDefinitions.value = DefinitionsState.Success(repository.getDefinitions(query))
        }
        return liveDefinitions
    }
}