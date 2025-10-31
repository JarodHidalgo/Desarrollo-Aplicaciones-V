import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NoteAdapter
    private lateinit var fabAdd: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dbHelper = DatabaseHelper(this)
        recyclerView = findViewById(R.id.recyclerView)
        fabAdd = findViewById(R.id.fabAdd)

        recyclerView.layoutManager = LinearLayoutManager(this)
        loadNotes()

        fabAdd.setOnClickListener {
            startActivity(Intent(this, AddEditNoteActivity::class.java))
        }
    }

    private fun loadNotes() {
        val notes = dbHelper.getAllNotes()
        adapter = NoteAdapter(notes, { note ->
            // Editar nota
            val intent = Intent(this, AddEditNoteActivity::class.java).apply {
                putExtra("note_id", note.id)
            }
            startActivity(intent)
        }, { note ->
            // Eliminar nota
            dbHelper.deleteNote(note.id)
            loadNotes()
        })
        recyclerView.adapter = adapter
    }

    override fun onResume() {
        super.onResume()
        loadNotes() // Recargar al volver
    }
}