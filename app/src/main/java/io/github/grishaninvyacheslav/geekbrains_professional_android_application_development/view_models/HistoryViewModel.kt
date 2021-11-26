package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.grishaninvyacheslav.domain.models.repository.DictionaryRepository
import io.github.grishaninvyacheslav.domain.models.repository.IDictionaryRepository
import io.github.grishaninvyacheslav.domain.models.repository.room.HistoryEntity
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.ApiHolder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class HistoryViewModel @Inject constructor() : ViewModel() {
    private inner class HistoryObserver : DisposableSingleObserver<List<io.github.grishaninvyacheslav.domain.models.repository.room.HistoryEntity>>() {
        override fun onSuccess(history: List<io.github.grishaninvyacheslav.domain.models.repository.room.HistoryEntity>) {
            liveHistory.value = history
        }

        override fun onError(e: Throwable) {
            e.printStackTrace()
        }
    }

    private val liveHistory: MutableLiveData<List<io.github.grishaninvyacheslav.domain.models.repository.room.HistoryEntity>> = MutableLiveData()
    private val repository: io.github.grishaninvyacheslav.domain.models.repository.IDictionaryRepository =
        io.github.grishaninvyacheslav.domain.models.repository.DictionaryRepository(ApiHolder.api)

    @SuppressLint("CheckResult")
    fun getData(): LiveData<List<io.github.grishaninvyacheslav.domain.models.repository.room.HistoryEntity>> {
        repository.getHistory()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(HistoryObserver())
        return liveHistory
    }

    fun filter(query: String) {
        liveHistory.value?.let {
            liveHistory.value = liveHistory.value!!.filter { value -> value.word.contains(query) }
        }
    }
}