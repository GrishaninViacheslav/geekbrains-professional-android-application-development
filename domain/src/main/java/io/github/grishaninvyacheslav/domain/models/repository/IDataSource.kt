package io.github.grishaninvyacheslav.domain.models.repository

import io.github.grishaninvyacheslav.domain.models.DictionaryWordDto
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface IDataSource {
    @GET("/api/v2/entries/en/{word}")
    fun getDefinitions(@Path("word") word: String): Call<List<DictionaryWordDto>>
}