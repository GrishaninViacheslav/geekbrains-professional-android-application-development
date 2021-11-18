package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.models.repository

import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.App
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.models.DictionaryWordDto
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.models.repository.room.HistoryEntity
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers

class DictionaryRepository(private val api: IDataSource) : IDictionaryRepository {
    override fun getDefinitions(word: String): Single<List<DictionaryWordDto>> =
        Single.fromCallable {
            val localDefinitions = App.instance.historyDao.getDataByWord(word)
            return@fromCallable if (localDefinitions != null) {
                List(1) {
                    DictionaryWordDto(localDefinitions.word, localDefinitions.phonetic ?: "")
                }
            } else {
                val response = api.getDefinitions(word).execute()
                if (response.isSuccessful) {
                    App.instance.historyDao.insert(
                        HistoryEntity(
                            response.body()!![0].word,
                            response.body()!![0].phonetic
                        )
                    )
                    response.body()!!
                } else {
                    throw Throwable("Слово не найдено")
                }
            }
        }.subscribeOn(Schedulers.io())

    override fun getHistory() = Single.fromCallable {
        return@fromCallable App.instance.historyDao.all()
    }
}