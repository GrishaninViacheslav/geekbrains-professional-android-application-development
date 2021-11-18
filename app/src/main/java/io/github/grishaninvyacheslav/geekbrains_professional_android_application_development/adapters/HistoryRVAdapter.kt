package io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.R
import io.github.grishaninvyacheslav.geekbrains_professional_android_application_development.domain.models.repository.room.HistoryEntity

class HistoryRVAdapter(
    var history: List<HistoryEntity>,
    private val onClickEvent: (word: String) -> Unit
) :
    RecyclerView.Adapter<HistoryRVAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.word_value)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_history, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        with(viewHolder.textView) {
            text = history[position].word
            setOnClickListener { onClickEvent(history[position].word) }
        }
    }

    override fun getItemCount() = history.size
}