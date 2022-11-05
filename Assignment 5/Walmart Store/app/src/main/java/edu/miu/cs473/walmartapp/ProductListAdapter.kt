package edu.miu.cs473.walmartapp

import android.content.Context
import android.opengl.Visibility
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import java.util.ResourceBundle


class ProductListAdapter(private val context: Context, private val products: Array<Product>, private val onClickListener: (Product) -> Unit): RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>()  {

    inner class ProductListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView
        val image: ImageView
        val price: TextView
        val color: TextView

        init {
            title = itemView.findViewById(R.id.title)
            image = itemView.findViewById(R.id.image)
            price = itemView.findViewById(R.id.price)
            color = itemView.findViewById(R.id.color)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListAdapter.ProductListViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.product_item, parent, false)
        return ProductListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductListAdapter.ProductListViewHolder, position: Int) {
        val product = products[position]
        val price = "$ ${product.price}"

        val imageId = context.resources.getIdentifier(product.image, "drawable", context.packageName)
        holder.image.setImageResource(imageId)
        holder.title.text =  product.title
        if (product.color.isBlank()) {
            holder.color.visibility = View.GONE
        } else {
            holder.color.visibility = View.VISIBLE
            holder.color.text = buildString {
                append("Color: ")
                append(product.color.uppercase())
            }
        }
        holder.price.text = buildString {
            append("Price: ")
            append(product.price)
        }

        holder.itemView.setOnClickListener { onClickListener(products[position]) }
    }

    override fun getItemCount(): Int {
        return products.size
    }

}