package io.github.grishaninvyacheslav.domain.models.repository

import io.github.grishaninvyacheslav.domain.models.DictionaryWordDto
import io.github.grishaninvyacheslav.domain.models.repository.room.HistoryEntity
import io.reactivex.Single

interface IDictionaryRepository {
    fun getDefinitions(word: String): Single<List<DictionaryWordDto>>
    fun getHistory(): Single<List<HistoryEntity>>
}