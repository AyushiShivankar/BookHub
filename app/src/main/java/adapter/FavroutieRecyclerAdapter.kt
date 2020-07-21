package adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ayushi.bookhub.R
import com.squareup.picasso.Picasso
import databse.BookEntity
import kotlinx.android.synthetic.main.recycler_favorite_single_row.view.*

class FavroutieRecyclerAdapter(val context:Context,val bookList: List<BookEntity>): RecyclerView.Adapter<FavroutieRecyclerAdapter.FavroutieViewHolder>() {
    class FavroutieViewHolder(view: View): RecyclerView.ViewHolder(view){
        val txtBookName: TextView =view.findViewById(R.id.txtFavBookTitle)
        val txtBookAuthor:TextView=view.findViewById(R.id.txtFavBookAuthor)
        val txtBookPrice:TextView=view.findViewById(R.id.txtFavBookPrice)
        val txtBookRating:TextView=view.findViewById(R.id.txtFavBookRating)
        val imgBookImage:ImageView=view.findViewById(R.id.imgFavBookImage)
        val llContent:LinearLayout=view.findViewById(R.id.llFavContent)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavroutieViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_favorite_single_row,parent,false)
        return FavroutieViewHolder(view)

    }

    override fun getItemCount(): Int {
        return bookList.size

    }

    override fun onBindViewHolder(holder: FavroutieViewHolder, position: Int) {
        val book=bookList[position]
        holder.txtBookName.text=book.bookName
        holder.txtBookAuthor.text=book.bookAuthor
        holder.txtBookPrice.text=book.bookPrice
        holder.txtBookRating.text=book.bookRating
        Picasso.get().load(book.bookImage).error(R.drawable.bookcover).into(holder.imgBookImage)

    }
}