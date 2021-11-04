package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.App
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.activity.MainActivity
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.fragments.SearchInputFragment
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.fragments.SearchResultFragment
import javax.inject.Singleton

@Component(
    modules = [
        ViewModelModule::class,
        ActivityModule::class,
        FragmentModule::class,
        AndroidSupportInjectionModule::class]
)
@Singleton
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(englishVocabularyApp: App)

    fun inject(mainActivity: MainActivity)

    fun inject(searchInputFragment: SearchInputFragment)
    fun inject(searchResultFragment: SearchResultFragment)
}