package edu.miu.cs473.cvbuilder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactsRecyclerViewAdapter(private val items: Array<ContactItem>, private val onClickListener: (Int) -> Unit): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    enum class ContactItemType(val value: Int) {
        Header(0),
        Item(1);

        companion object {
            fun fromInt(value: Int): ContactItemType? {
                return when (value) {
                    0 -> Header
                    1 -> Item
                    else -> null
                }
            }
        }
    }

    class ContactItemViewHolder(view: View, private val onClickListener: (Int) -> Unit) : RecyclerView.ViewHolder(view), View.OnClickListener {
        val valueField: TextView
        val detailField: TextView
        val imageView: ImageView

        init {
            valueField = view.findViewById(R.id.value_field)
            detailField = view.findViewById(R.id.detail_field)
            imageView = view.findViewById(R.id.image_view)
            view.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            onClickListener(adapterPosition)
        }
    }

    class HeaderItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            textView = view.findViewById(R.id.title_header_field)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemType = ContactItemType.fromInt(viewType)
        val inflater = LayoutInflater.from(parent.context)

        return when (itemType) {
            ContactItemType.Header -> HeaderItemViewHolder(inflater.inflate(R.layout.title_header_item, parent, false))
            ContactItemType.Item -> ContactItemViewHolder(inflater.inflate(R.layout.contact_item, parent, false)) { itemPosition ->
                onClickListener(itemPosition - 1)
            }
            else -> throw RuntimeException("Invalid item type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is ContactItemViewHolder) {
            val contactItem = items[position - 1]
            holder.valueField.text = contactItem.value
            holder.detailField.text = contactItem.detail
            holder.imageView.setImageResource(contactItem.image)
        } else if (holder is HeaderItemViewHolder) {
            holder.textView.text = "My Contacts"
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return ContactItemType.Header.value
        }
        return ContactItemType.Item.value
    }

    override fun getItemCount(): Int {
        return items.size + 1
    }
}