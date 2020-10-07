package ucb.bo.edu.ejercicio1.ui.login
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_create_book.*
import ucb.bo.edu.ejercicio1.*

class CreateBookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_book)

        val save = findViewById<Button>(R.id.btn_save)
        save.setOnClickListener {
            val title = editTextTitle.text.toString()
            val pages = editTextPages.text.toString()
            val editorial = editTextEditorial.text.toString()
            val author = editTextAuthor.text.toString()
            val description = editTextDescription.text.toString()
            val photoUrl = editTextPhotoUrl.text.toString()
            val intent:Intent = Intent(this, MainActivity::class.java)
            intent.putExtra("title", title)
            intent.putExtra("pages", pages)
            intent.putExtra("editorial", editorial)
            intent.putExtra("author", author)
            intent.putExtra("description", description)
            intent.putExtra("photoUrl", photoUrl)
            startActivity(intent)
        }
    }
}


