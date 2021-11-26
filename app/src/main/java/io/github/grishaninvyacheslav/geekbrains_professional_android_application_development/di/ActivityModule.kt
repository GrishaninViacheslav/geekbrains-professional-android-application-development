package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.activity.MainActivity

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}