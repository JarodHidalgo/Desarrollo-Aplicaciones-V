import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddEditNoteActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var etTitle: EditText
    private lateinit var etContent: EditText
    private lateinit var btnSave: Button
    private var noteId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_note)

        dbHelper = DatabaseHelper(this)
        etTitle = findViewById(R.id.etTitle)
        etContent = findViewById(R.id.etContent)
        btnSave = findViewById(R.id.btnSave)

        noteId = intent.getIntExtra("note_id", -1).takeIf { it != -1 }

        noteId?.let { id ->
            val note = dbHelper.getAllNotes().find { it.id == id }
            note?.let {
                etTitle.setText(it.title)
                etContent.setText(it.content)
            }
        }

        btnSave.setOnClickListener {
            val title = etTitle.text.toString().trim()
            val content = etContent.text.toString().trim()
            if (title.isNotEmpty() && content.isNotEmpty()) {
                val note = Note(noteId ?: 0, title, content)
                if (noteId == null) {
                    dbHelper.insertNote(note)
                    Toast.makeText(this, "Nota agregada", Toast.LENGTH_SHORT).show()
                } else {
                    dbHelper.updateNote(note)
                    Toast.makeText(this, "Nota actualizada", Toast.LENGTH_SHORT).show()
                }
                finish()
            } else {
                Toast.makeText(this, "Completa todos los campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}