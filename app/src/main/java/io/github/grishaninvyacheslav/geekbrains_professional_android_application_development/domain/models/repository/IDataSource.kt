package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.models.repository

import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.models.DictionaryWordDto
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface IDataSource {
    @GET("/api/v2/entries/en/{word}")
    fun getDefinitionsAsync(@Path("word") word: String): Deferred<List<DictionaryWordDto>>
}