package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models.search_result

import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.models.DictionaryWordDto

sealed class DefinitionsState {
    data class Success(val dtosList: List<DictionaryWordDto>) : DefinitionsState()
    data class Error(val error: Throwable) : DefinitionsState()
    object Loading : DefinitionsState()
}