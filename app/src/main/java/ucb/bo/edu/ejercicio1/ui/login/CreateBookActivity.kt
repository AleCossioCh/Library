package ucb.bo.edu.ejercicio1.ui.login
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.coroutines.GlobalScope
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_create_book.*
import kotlinx.coroutines.async
import ucb.bo.edu.ejercicio1.*

class CreateBookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_book)
        val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
        val repository = BookRepository(bookDao)

        val save = findViewById<Button>(R.id.btn_save)
        save.setOnClickListener {
            val title = editTextTitle.text.toString()
            val pages = editTextPages.text.toString()
            val editorial = editTextEditorial.text.toString()
            val author = editTextAuthor.text.toString()
            val description = editTextDescription.text.toString()
            val photoUrl = editTextPhotoUrl.text.toString()
            val intent:Intent = Intent(this, MainActivity::class.java)
            GlobalScope.async {
                repository.insert(Book(title, pages, editorial,author,description,photoUrl))
            }
            startActivity(intent)
        }
    }
}


