package adapter

import activity.DescriptionActivity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.ayushi.bookhub.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_dashboard_single_row.view.*
import model.Book


class DashboardRecyclerAdapter(val context: Context, val itemList: ArrayList<Book>):RecyclerView.Adapter<DashboardRecyclerAdapter.DashBoardViewHolder>(){
    class DashBoardViewHolder(view:View):RecyclerView.ViewHolder(view){
        val txtBookName:TextView=view.findViewById(R.id.txtBookName)
        val txtBookAuthor:TextView=view.findViewById(R.id.txtBookAuthor)
        val txtBookPrice:TextView=view.findViewById(R.id.txtBookPrice)
        val txtBookRating:TextView=view.findViewById(R.id.txtBookRating)
        val txtBookImage:ImageView=view.findViewById(R.id.imgBookImage)
        val llContent:LinearLayout=view.findViewById((R.id.llContent))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashBoardViewHolder{
        val view=LayoutInflater.from(parent.context).inflate(R.layout.recycler_dashboard_single_row,parent,false)
        return DashBoardViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: DashBoardViewHolder, position: Int) {
        val book=itemList[position]
        holder.txtBookName.text=book.bookName
        holder.txtBookAuthor.text=book.bookAuthor
        holder.txtBookPrice.text=book.bookPrice
        holder.txtBookRating.text=book.bookRating
        //holder.txtBookImage.setImageResource(book.bookImage)
        Picasso.get().load(book.bookImage).error(R.drawable.bookcover).into(holder.txtBookImage)
        holder.llContent.setOnClickListener {
            val intent=Intent(context,DescriptionActivity::class.java)
            intent.putExtra("book_id",book.bookId)
            context.startActivity(intent)
            Toast.makeText(context,"Clicked on ${holder.txtBookName.text}",Toast.LENGTH_SHORT).show() }

           }
}