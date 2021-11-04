package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.github.terrakok.cicerone.Router
import dagger.android.support.AndroidSupportInjection
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.App
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.R
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.databinding.FragmentSearchResultBinding
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models.SearchInputViewModel
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models.search_result.DefinitionsState
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models.search_result.SearchResultViewModel
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.BackButtonListener
import javax.inject.Inject

class SearchResultFragment : Fragment(), BackButtonListener {
    private val router: Router = App.instance.router

    private var _view: FragmentSearchResultBinding? = null
    private val view get() = _view!!

    private fun renderData(definitionsState: DefinitionsState) {
        when (definitionsState) {
            is DefinitionsState.Success ->
                setTitle(definitionsState.dtosList[0].word, definitionsState.dtosList[0].phonetic)
            is DefinitionsState.Error -> {
                when (definitionsState.error) {
                    is java.net.UnknownHostException ->
                        showErrorMessage(App.instance.getString(R.string.error_500))
                    is retrofit2.adapter.rxjava2.HttpException ->
                        showErrorMessage(App.instance.getString(R.string.error_404))
                }
            }
        }
    }

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var model: SearchResultViewModel

    companion object {
        val QUERY_ARG = "QUERY"

        @JvmStatic
        fun newInstance(query: String) = SearchResultFragment().apply {
            arguments = Bundle().apply { putString(QUERY_ARG, query) }
        }
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _view = FragmentSearchResultBinding.inflate(inflater, container, false)
        model = viewModelFactory.create(SearchResultViewModel::class.java)
        model.getDefinitions(requireArguments().getString(QUERY_ARG)!!)
            .observe(viewLifecycleOwner) { renderData(it) }
        return view.root
    }

    fun setTitle(wordValue: String, phoneticValue: String) = with(view) {
        word.text = wordValue
        phonetic.text = phoneticValue
        progressBar.visibility = GONE
        errorMessage.visibility = GONE
    }

    fun showErrorMessage(message: String) = with(view.errorMessage) {
        text = message
        visibility = VISIBLE
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