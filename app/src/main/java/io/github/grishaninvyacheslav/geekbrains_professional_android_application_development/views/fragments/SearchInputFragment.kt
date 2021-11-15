package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.terrakok.cicerone.Router
import dagger.android.support.AndroidSupportInjection
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.App
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.databinding.FragmentSearchInputBinding
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models.AppState
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models.SearchInputViewModel
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.BackButtonListener
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.Screens
import javax.inject.Inject

class SearchInputFragment : Fragment(), BackButtonListener {
    private var _view: FragmentSearchInputBinding? = null
    private val view get() = _view!!

    private val router: Router = App.instance.router

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var model: SearchInputViewModel

    private fun setViewListeners() {
        with(view) {
            searchInput.setOnKeyListener { v, keyCode, event ->
                if ((event.action == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    model.getData(searchInput.text.toString())
                        .observe(viewLifecycleOwner) { renderData(it) }
                    return@setOnKeyListener true
                }
                view.errorMessage.text = ""
                return@setOnKeyListener false
            }
            searchConfirm.setOnClickListener {
                model.getData(searchInput.text.toString())
                    .observe(viewLifecycleOwner) { renderData(it) }
            }
            history.setOnClickListener { showHistory() }
        }
    }

    private fun showHistory() = router.navigateTo(Screens.searchHistory())


    private fun removeViewListeners() {
        // TODO("NOT YET IMPLEMENTED")
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success ->
                router.navigateTo(Screens.searchResult(view.searchInput.text.toString()))
            is AppState.Loading ->
                removeViewListeners()
            is AppState.Error -> {
                setViewListeners()
                appState.error.message?.let { showMessage(it) }
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = SearchInputFragment()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _view = FragmentSearchInputBinding.inflate(inflater, container, false)
        model = viewModelFactory.create(SearchInputViewModel::class.java)
        return view.apply { setViewListeners() }.root
    }

    fun showMessage(message: String) {
        view.errorMessage.text = message
        Log.d("[SearchInputFragment]", "view.errorMessage.text: ${view.errorMessage.text}")
        Toast.makeText(
            context,
            "view.errorMessage.text: ${view.errorMessage.text}",
            Toast.LENGTH_SHORT
        ).show()
    }

    override fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _view = null
    }
}