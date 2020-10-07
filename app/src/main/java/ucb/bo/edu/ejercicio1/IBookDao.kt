package ucb.bo.edu.ejercicio1

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy

@Dao
interface IBookDao {
    @Query("SELECT * FROM book_table")
    fun getAll(): List<Book>

    @Query("SELECT * FROM book_table WHERE id LIKE :id LIMIT 1")
    fun findById(id: String): Book

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(book:Book)

    @Delete
    fun delete(user: Book)
}