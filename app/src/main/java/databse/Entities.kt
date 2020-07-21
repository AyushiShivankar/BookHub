package databse

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="books")
data class BookEntity(
    @PrimaryKey val book_id:Int,
    @ColumnInfo(name="bookName") val bookName:String,
    @ColumnInfo(name= "bookAuthor")val bookAuthor:String,
    @ColumnInfo(name="bookPrice")val bookPrice:String,
    @ColumnInfo(name="bookRating")val bookRating:String,
    @ColumnInfo(name="bookDesc")val bookDesc:String,
    @ColumnInfo(name="bookImage")val bookImage:String
)