package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.terrakok.cicerone.Router
import dagger.android.support.AndroidSupportInjection
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.App
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.adapters.HistoryRVAdapter
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.databinding.FragmentHistoryBinding
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.view_models.HistoryViewModel
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.BackButtonListener
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.views.Screens
import javax.inject.Inject

class HistoryFragment : Fragment(), BackButtonListener {
    private var _view: FragmentHistoryBinding? = null
    private val view get() = _view!!

    private val router: Router = App.instance.router

    var adapter: HistoryRVAdapter? = null

    @Inject
    internal lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var model: HistoryViewModel

    companion object {
        @JvmStatic
        fun newInstance() = HistoryFragment()
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _view = FragmentHistoryBinding.inflate(inflater, container, false).apply {
            searchConfirm.setOnClickListener {
                model.filter(searchInput.text.toString())
            }
        }
        model = viewModelFactory.create(HistoryViewModel::class.java)
        model.getData().observe(viewLifecycleOwner) {
            if (adapter == null) {
                view.historyList.layoutManager = LinearLayoutManager(context)
                adapter = HistoryRVAdapter(it) { word ->
                    router.navigateTo(Screens.searchResult(word))
                }
                view.historyList.adapter = adapter
            } else {
                adapter!!.history = it
                adapter!!.notifyDataSetChanged()
            }
        }
        return view.root
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