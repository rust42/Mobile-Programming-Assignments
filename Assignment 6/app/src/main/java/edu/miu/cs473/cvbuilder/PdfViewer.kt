package edu.miu.cs473.cvbuilder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.barteksc.pdfviewer.PDFView

class PdfViewer : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "Sandeep Koirala CV"
        setContentView(R.layout.activity_pdf_viewer)

        val pdfView = findViewById<PDFView>(R.id.pdfView)

        pdfView.fromAsset("Sandeep.Koirala-Resume.pdf")
            .enableSwipe(true) /* allows to block changing pages using swipe*/
            .swipeHorizontal(false)
            .enableDoubletap(true)
            .onPageError { page, t ->
                Toast.makeText(this, t.message, Toast.LENGTH_LONG).show()
            }
            .onError {
                Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
            }
            .load()
    }
}