package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development

import android.app.Application
import androidx.room.Room
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.Router
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.di.DaggerAppComponent
import javax.inject.Inject

class App : Application(), HasAndroidInjector {
    lateinit var historyDb: io.github.grishaninvyacheslav.domain.models.repository.room.HistoryDataBase
    lateinit var historyDao: io.github.grishaninvyacheslav.domain.models.repository.room.HistoryDao

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

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

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

        historyDb = Room.databaseBuilder(applicationContext, io.github.grishaninvyacheslav.domain.models.repository.room.HistoryDataBase::class.java, "HistoryDB")
            .build()
        historyDao = historyDb.historyDao()
    }
}