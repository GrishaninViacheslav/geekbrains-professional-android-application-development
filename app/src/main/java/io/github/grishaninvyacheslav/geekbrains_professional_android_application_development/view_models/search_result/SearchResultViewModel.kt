package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models.search_result

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.grishaninvyacheslav.domain.models.DictionaryWordDto
import io.github.grishaninvyacheslav.domain.models.repository.DictionaryRepository
import io.github.grishaninvyacheslav.domain.models.repository.IDictionaryRepository
import io.github.grishaninvyacheslav.domain.schedulers.DefaultSchedulers
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.ApiHolder
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class SearchResultViewModel @Inject constructor() : ViewModel() {
    private val liveDefinitions: MutableLiveData<DefinitionsState> = MutableLiveData()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()
    private val repository: io.github.grishaninvyacheslav.domain.models.repository.IDictionaryRepository =
        io.github.grishaninvyacheslav.domain.models.repository.DictionaryRepository(ApiHolder.api)

    private inner class DefinitionsLoadObserver :
        DisposableSingleObserver<List<io.github.grishaninvyacheslav.domain.models.DictionaryWordDto>>() {
        override fun onSuccess(value: List<io.github.grishaninvyacheslav.domain.models.DictionaryWordDto>) {
            liveDefinitions.value = DefinitionsState.Success(value)
        }

        override fun onError(error: Throwable) {
            error.printStackTrace()
            liveDefinitions.value = DefinitionsState.Error(error)
        }
    }

    fun getDefinitions(query: String): MutableLiveData<DefinitionsState> {
        compositeDisposable.add(
            repository
                .getDefinitions(query)
                .observeOn(io.github.grishaninvyacheslav.domain.schedulers.DefaultSchedulers.main())
                .subscribeWith(DefinitionsLoadObserver())
        )
        return liveDefinitions
    }
}