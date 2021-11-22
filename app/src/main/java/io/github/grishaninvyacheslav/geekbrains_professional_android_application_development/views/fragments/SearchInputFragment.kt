package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.fragments

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import com.google.android.material.button.MaterialButton
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.App
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.R
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models.AppState
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models.SearchInputViewModel
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.BackButtonListener
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.Screens
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.viewById
import org.koin.android.scope.getOrCreateScope


class SearchInputFragment : Fragment(), BackButtonListener {
    private val searchInput by viewById<EditText>(R.id.search_input)
    private val searchConfirm by viewById<MaterialButton>(R.id.search_confirm)
    private val errorMessage by viewById<TextView>(R.id.error_message)

    private val router: Router = App.instance.router

    private val model: SearchInputViewModel by getOrCreateScope().value.inject()

    private fun setViewListeners() {
        searchInput.setOnKeyListener { v, keyCode, event ->
            if ((event.action == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                model.getData(searchInput.text.toString())
                    .observe(viewLifecycleOwner) { renderData(it) }
                return@setOnKeyListener true
            }
            errorMessage.text = ""
            return@setOnKeyListener false
        }
        searchConfirm.setOnClickListener {
            model.getData(searchInput.text.toString())
                .observe(viewLifecycleOwner) { renderData(it) }
        }
    }

    private fun removeViewListeners() {
        // TODO("NOT YET IMPLEMENTED")
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success ->
                router.navigateTo(Screens.searchResult(searchInput.text.toString()))
            is AppState.Loading ->
                removeViewListeners()
            is AppState.Error -> {
                setViewListeners()
                appState.error.message?.let { showMessage(it) }
            }
        }
    }

    private fun showMessage(message: String) {
        errorMessage.text = message
    }

    companion object {
        @JvmStatic
        fun newInstance() = SearchInputFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_search_input, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setViewListeners()
    }

    override fun backPressed(): Boolean {
        router.exit()
        return true
    }
}