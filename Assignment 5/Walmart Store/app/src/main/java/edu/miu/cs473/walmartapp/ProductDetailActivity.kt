package edu.miu.cs473.walmartapp

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import org.w3c.dom.Text


class ProductDetailActivity: AppCompatActivity() {

    companion object {
        const val SelectedProductKey = "com.walmartapp.selectedProduct.key"
    }

    private lateinit var product: Product
    private lateinit var imageView: ImageView
    private lateinit var title: TextView
    private lateinit var color: TextView
    private lateinit var productId: TextView
    private lateinit var description: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val product = intent.getParcelableExtra<Product>(SelectedProductKey)
        if (product == null) {
            finish()
            return
        }

        this.product = product
        setContentView(R.layout.activity_product_detail)
        imageView = findViewById(R.id.imageView)
        title = findViewById(R.id.title)
        color = findViewById(R.id.color)
        productId = findViewById(R.id.product_id)
        description = findViewById(R.id.product_description)
        setupView()
    }

    private fun setupView() {
        imageView.setImageResource(resources.getIdentifier(product.image, "drawable", packageName))
        title.text = product.title
        if (product.color.isNotEmpty()) {
            color.text = buildString {
                append("Color: ")
                append(product.color)
            }
            color.visibility = View.VISIBLE
        } else {
            color.visibility = View.GONE
        }

        productId.text = buildString {
            append("Walmart #: ")
            append(product.itemId)
        }

        description.text = product.desc
    }
}