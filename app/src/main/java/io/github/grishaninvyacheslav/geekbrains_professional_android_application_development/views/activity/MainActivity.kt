package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.terrakok.cicerone.Router
import com.github.terrakok.cicerone.androidx.AppNavigator
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.R
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.App
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.databinding.ActivityMainBinding
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.BackButtonListener
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.Screens

class MainActivity : AppCompatActivity(), BackButtonListener {
    private val router: Router = App.instance.router

    private var _view: ActivityMainBinding? = null
    private val view get() = _view!!

    private val navigator = AppNavigator(this, R.id.container)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _view = ActivityMainBinding.inflate(layoutInflater)
        setContentView(view.root)
        router.replaceScreen(Screens.searchInput())
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun onDestroy() {
        super.onDestroy()
        _view = null
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
    }

    override fun backPressed(): Boolean {
        router.exit()
        return true
    }
}