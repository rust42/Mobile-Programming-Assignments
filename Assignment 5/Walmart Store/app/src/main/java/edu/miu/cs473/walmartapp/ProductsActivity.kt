package edu.miu.cs473.walmartapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager


class ProductsActivity: AppCompatActivity() {

    companion object {
        const val SelectedCategoryKey = "com.walmartapp.selectedCategory.type"
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var selectedCategory: SelectedCategory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val selectedCategory = intent.getIntExtra(SelectedCategoryKey, 0)
        this.selectedCategory = SelectedCategory.fromInt(selectedCategory)

        setContentView(R.layout.activity_products)
        setupRecyclerView()
        title = this.selectedCategory.title

    }

    private fun setupRecyclerView() {
        val products = when (selectedCategory) {
            SelectedCategory.Electronics -> ProductFactory.electronics;
            SelectedCategory.Beauty -> ProductFactory.beauties;
            SelectedCategory.Clothing -> ProductFactory.clothes;
            SelectedCategory.Food -> ProductFactory.food;
        }
        recyclerView = findViewById(R.id.recycler_view)
        val adapter = ProductListAdapter(this, products) { product ->
            showProductDetail(product)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun showProductDetail(product: Product) {
        val intent = Intent(this, ProductDetailActivity::class.java)
        intent.putExtra(ProductDetailActivity.SelectedProductKey, product)
        startActivity(intent)
    }
}