package fragment

import adapter.FavroutieRecyclerAdapter
import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.ayushi.bookhub.R
import databse.BookDatabase
import databse.BookEntity

/**
 * A simple [Fragment] subclass.
 */
class FavroutiesFragment : Fragment() {
    lateinit var recyclerFavroutie: RecyclerView
    lateinit var progressLayout:RelativeLayout
    lateinit var progressBar:ProgressBar
    lateinit var layoutManager:RecyclerView.LayoutManager
    lateinit var recyclerAdapter:FavroutieRecyclerAdapter
    var dbBookList= listOf<BookEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_favrouties,container,false)
        recyclerFavroutie=view.findViewById(R.id.recyclerFavroutie)
        progressLayout=view.findViewById(R.id.progressLayout)
        progressBar=view.findViewById(R.id.progressBar)

        layoutManager= GridLayoutManager(activity as Context,2 )
        dbBookList=RetrieveFavrouties(activity as Context).execute().get()
        if(activity!=null){
            progressLayout.visibility=View.GONE
            recyclerAdapter= FavroutieRecyclerAdapter(activity as Context,dbBookList)
            recyclerFavroutie.adapter=recyclerAdapter
            recyclerFavroutie.layoutManager=layoutManager

        }
        return view
    }
    class RetrieveFavrouties(val context: Context):AsyncTask<Void,Void,List<BookEntity>>(){
        override fun doInBackground(vararg params: Void?): List<BookEntity> {
            val db= Room.databaseBuilder(context,BookDatabase::class.java,"books-db").build()
            return db.bookDao().gelAllBooks()
        }

    }

}
