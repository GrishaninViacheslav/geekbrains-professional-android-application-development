package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.fragments.HistoryFragment
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.fragments.SearchInputFragment
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.fragments.SearchResultFragment

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeSearchInputFragment(): SearchInputFragment

    @ContributesAndroidInjector
    abstract fun contributeSearchResultFragment(): SearchResultFragment

    @ContributesAndroidInjector
    abstract fun contributeHistoryFragment(): HistoryFragment
}