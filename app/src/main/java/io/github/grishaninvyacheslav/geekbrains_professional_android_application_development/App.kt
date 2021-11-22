package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development

import android.app.Application
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.di.application
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.di.mainScreen
import org.koin.core.context.GlobalContext.startKoin

class App : Application() {
    companion object {
        lateinit var instance: App
            private set
    }

    private val cicerone: Cicerone<Router> by lazy {
        Cicerone.create()
    }
    val navigatorHolder get() = cicerone.getNavigatorHolder()
    val router get() = cicerone.router

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin {
            modules(listOf(application, mainScreen))
        }
    }
}