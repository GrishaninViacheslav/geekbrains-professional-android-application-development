package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.App
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.R
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class SearchInputViewModel @Inject constructor() : ViewModel() {
    private val liveMessage: MutableLiveData<AppState> = MutableLiveData()
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private inner class SubmitObserver : DisposableSingleObserver<Unit>() {
        override fun onSuccess(t: Unit) {
            liveMessage.value = AppState.Success
        }

        override fun onError(e: Throwable) {
            liveMessage.value = AppState.Error(e)
        }
    }

    fun getData(query: String): LiveData<AppState> {
        compositeDisposable.add(
            submitQuery(query)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { liveMessage.value = AppState.Loading }
                .subscribeWith(SubmitObserver())
        )
        return liveMessage
    }

    // TODO: вынести в интерактор
    private fun submitQuery(query: String): Single<Unit> = Single.fromCallable {
        (!query.contains(" ") && query.isNotBlank()).also { isValid ->
            if (!isValid) {
                if (query.contains(" ")) {
                    throw Throwable(App.instance.getString(R.string.query_is_invalid_more_than_one_word))
                } else if (query.isBlank()) {
                    throw Throwable(App.instance.getString(R.string.query_is_invalid_more_than_no_word))
                }
            }
        }
    }
}