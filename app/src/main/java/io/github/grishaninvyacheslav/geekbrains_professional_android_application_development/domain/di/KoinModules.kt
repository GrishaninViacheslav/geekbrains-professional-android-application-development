package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.di.koin

import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.di.NAME_REMOTE
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.models.repository.DictionaryRepository
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.models.repository.IDictionaryRepository
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models.SearchInputViewModel
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models.search_result.SearchResultViewModel
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.ApiHolder
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single<IDictionaryRepository>(named(NAME_REMOTE)) { DictionaryRepository(ApiHolder.api) }
}

val mainScreen = module {
    factory { SearchInputViewModel() }
    factory { SearchResultViewModel() }
}