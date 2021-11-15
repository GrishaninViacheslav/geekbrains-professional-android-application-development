package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models.HistoryViewModel
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models.SearchInputViewModel
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models.ViewModelFactory
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models.search_result.SearchResultViewModel

@Module
internal abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(SearchInputViewModel::class)
    protected abstract fun searchInputViewModel(searchInputViewModel: SearchInputViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchResultViewModel::class)
    protected abstract fun searchResultViewModel(searchResultViewModel: SearchResultViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HistoryViewModel::class)
    protected abstract fun historyViewModel(historyViewModel: HistoryViewModel): ViewModel
}