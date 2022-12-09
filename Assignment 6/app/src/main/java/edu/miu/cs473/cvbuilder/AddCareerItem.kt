package edu.miu.cs473.cvbuilder

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity

class AddCareerItem : AppCompatActivity() {

    private lateinit var titleField: EditText
    private lateinit var detailField: EditText
    private lateinit var addButton: Button

    companion object {
        const val resultItemKey = "com.cvbuilder.resultItem"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_career_item)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.title = "Add a new note"
        titleField = findViewById(R.id.title_field)
        detailField = findViewById(R.id.details_field)
        addButton = findViewById(R.id.add_button)

        addButton.setOnClickListener(this::addItem)
    }

    private fun addItem(view: View) {
        val item = HomeItem(titleField.text.toString(), detailField.text.toString())
        intent.putExtra(resultItemKey, item)
        setResult(RESULT_OK, intent)
        finish()
    }
}