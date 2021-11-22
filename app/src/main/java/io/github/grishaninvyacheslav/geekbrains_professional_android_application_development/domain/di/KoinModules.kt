package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.di

import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.models.repository.DictionaryRepository
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.models.repository.IDictionaryRepository
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models.SearchInputViewModel
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models.search_result.SearchResultViewModel
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.ApiHolder
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.fragments.SearchInputFragment
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.fragments.SearchResultFragment
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single<IDictionaryRepository>(named(NAME_REMOTE)) { DictionaryRepository(ApiHolder.api) }
}

val mainScreen = module {
    scope(named<SearchInputFragment>()) {
        viewModel { SearchInputViewModel() }
    }
    scope(named<SearchResultFragment>()) {
        viewModel { SearchResultViewModel() }
    }
}