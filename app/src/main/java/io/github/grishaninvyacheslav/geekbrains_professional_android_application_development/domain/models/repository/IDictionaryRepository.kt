package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.models.repository

import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.models.DictionaryWordDto

interface IDictionaryRepository {
    suspend fun getDefinitions(word: String): List<DictionaryWordDto>
}