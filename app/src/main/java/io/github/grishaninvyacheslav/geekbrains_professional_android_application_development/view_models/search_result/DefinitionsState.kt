package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models.search_result

import android.os.Parcelable
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.models.DictionaryWordDto
import kotlinx.android.parcel.Parcelize

sealed class DefinitionsState {
    @Parcelize
    data class Success(val dtosList: List<DictionaryWordDto>) : DefinitionsState(), Parcelable
    @Parcelize
    data class Error(val error: Throwable) : DefinitionsState(), Parcelable
    @Parcelize
    object Loading : DefinitionsState(), Parcelable
}