package ucb.bo.edu.ejercicio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import ucb.bo.edu.ejercicio1.ui.login.CreateBookActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
        val repository = BookRepository(bookDao)

        GlobalScope.launch {


            //repository.insert(Book("Crimen y castigo", "2000", "editorial1","Fiódor Dostoievski","El análisis psicológico que realiza del protagonista, el estudiante Rodión Raskólnikov, que se enfrenta a un dilema moral.", "https://images.cdn3.buscalibre.com/fit-in/360x360/57/f4/57f45dd845bc86570769166c970d9047.jpg"))
            //repository.insert(Book("Cien años de soledad", "3000", "editorial2","Gabriel García Márquez","La novela del escritor colombiano que narra las vicisitudes de la familia Buendía a lo largo de siete generaciones en el ficticio pueblo de Macondo es considerado por muchos la mejor novela de todos los tiempos.", "https://miro.medium.com/max/406/0*z_ffgaKdUG7rIUCo.jpg"))
            //repository.insert(Book("Don Quijote de la Mancha", "2024", "editorial3","Miguel de Cervantes","Esta novela de caballería está considerada como precursora de la novela moderna.", "https://www.elejandria.com/covers/Don_Quijote_de_la_Mancha-Cervantes_Miguel-lg.png"))
            //repository.insert(Book("La Divina comedia", "2055", "editorial4","Dante","Dividido en cánticas (Infierno, Purgatorio y Paraíso), Dante, Beatriz y Virgilio protagonizan este poema que resume los conocimientos desde la civilización clásica a la medieval, las creencias o la filosofía. ", "https://images-na.ssl-images-amazon.com/images/I/51jyV+HNS4L._SX331_BO1,204,203,200_.jpg"))
            //repository.insert(Book("El Principito", "2059", "editorial5","Antoine de Saint-Exupéry","Todo un clásico. El escritor y aviador francés escribió este libro infantil, publicado en 1943, que a día de hoy sigue siendo uno de los libros más vendidos de todos los tiempos.", "https://d26lpennugtm8s.cloudfront.net/stores/001/029/689/products/78321423_2667428979981701_1469574183322124288_o1-0278b16767d76dca9615744382996329-640-0.jpg"))

            val lista = repository.getListBooks()
            //lista.forEach {
            //    Log.d("DBTEST","Id book = ${it.id}, Title:${it.title}, Pages:${it.pages},Editorial:${it.editorial},author:${it.author},description:${it.description},photoUrl:${it.photoUrl}")
            //}
            recycleViewBooks.adapter= BookListAdapter(ArrayList(lista) , applicationContext)
            val linearLayoutManager = LinearLayoutManager(applicationContext)
            linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
            recycleViewBooks.layoutManager = linearLayoutManager
        }


        addBook.setOnClickListener {
            val intent = Intent(this, CreateBookActivity::class.java)
            startActivity(intent);
        }
    }
}