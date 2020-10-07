package ucb.bo.edu.ejercicio1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_book.view.*

class BookListAdapter(var list : ArrayList<Book>, applicationContext: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_book, parent, false)
        return BookListViewHolder(view)
    }

    class BookListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val book = list[position]
        holder.itemView.textViewTitle.text = book.title
        holder.itemView.textViewDescription.text = book.description
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
