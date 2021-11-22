package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.github.terrakok.cicerone.Router
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.App
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.R
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models.search_result.DefinitionsState
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models.search_result.SearchResultViewModel
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.BackButtonListener
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.viewById
import org.koin.android.scope.getOrCreateScope

class SearchResultFragment : Fragment(), BackButtonListener {
    private val word by viewById<TextView>(R.id.word)
    private val phonetic by viewById<TextView>(R.id.phonetic)
    private val progressBar by viewById<ProgressBar>(R.id.progress_bar)
    private val errorMessage by viewById<TextView>(R.id.error_message)

    private val router: Router = App.instance.router

    private var definitionsState: DefinitionsState? = null

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

    private val model: SearchResultViewModel by getOrCreateScope().value.inject()

    companion object {
        val QUERY_ARG = "QUERY"
        val DEFINITIONS_STATE_ARG = "DEFINITIONS_STATE"

        @JvmStatic
        fun newInstance(query: String) = SearchResultFragment().apply {
            arguments = Bundle().apply { putString(QUERY_ARG, query) }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (savedInstanceState == null) {
            model.getDefinitions(requireArguments().getString(QUERY_ARG)!!)
                .observe(viewLifecycleOwner) {
                    definitionsState = it
                    renderData(definitionsState!!)
                }
        }
        return inflater.inflate(R.layout.fragment_search_result, container, false)
    }

    override fun onSaveInstanceState(savedInstanceState: Bundle) {
        super.onSaveInstanceState(savedInstanceState)
        when (definitionsState) {
            is DefinitionsState.Success -> savedInstanceState.putParcelable(
                DEFINITIONS_STATE_ARG,
                definitionsState as DefinitionsState.Success
            )
            is DefinitionsState.Error -> savedInstanceState.putParcelable(
                DEFINITIONS_STATE_ARG,
                definitionsState as DefinitionsState.Error
            )
            is DefinitionsState.Loading -> savedInstanceState.putParcelable(
                DEFINITIONS_STATE_ARG,
                definitionsState as DefinitionsState.Loading
            )
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        if(savedInstanceState == null){
            return
        }
        definitionsState = savedInstanceState.getParcelable(DEFINITIONS_STATE_ARG)
        renderData(definitionsState!!)
    }

    fun setTitle(wordValue: String, phoneticValue: String) {
        word.text = wordValue
        phonetic.text = phoneticValue
        progressBar.visibility = GONE
        errorMessage.visibility = GONE
    }

    fun showErrorMessage(message: String) = with(errorMessage) {
        text = message
        visibility = VISIBLE
    }

    override fun backPressed(): Boolean {
        router.exit()
        return true
    }
}