package edu.miu.cs473.cvbuilder

import android.content.Context
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import java.util.InvalidPropertiesFormatException


class HomeItemsAdapter(context: Context, data: MutableList<HomeAdapterItem>): ArrayAdapter<HomeItemsAdapter.HomeAdapterItem>(context, R.layout.main_section, data), OnClickListener {

    interface HomeAdapterItem { }
    class Header: HomeAdapterItem
    class Item(val item: HomeItem): HomeAdapterItem

    private val data: MutableList<HomeAdapterItem>
    private val inflater: LayoutInflater

    init {
        this.data = data;
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    class ViewHolder {
        lateinit var title: TextView
        lateinit var detail: TextView
    }

    class HeaderViewHolder { }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var vi = convertView
        var viewHolder: Any

        val item = data[position]


        if (convertView == null) {
            when(item) {
                is Header -> {
                    vi = inflater.inflate(R.layout.home_header_item, null)
                    viewHolder = HeaderViewHolder()
                    vi.tag = vi
                }
                is Item -> {
                    vi = inflater.inflate(R.layout.main_section, null)
                    viewHolder = ViewHolder()
                    viewHolder.title = vi.findViewById(R.id.title)
                    viewHolder.detail = vi.findViewById(R.id.detail)
                    vi.tag = viewHolder
                }
                else -> viewHolder = HeaderViewHolder()
            }
        } else {
            viewHolder = convertView.tag
        }

        when (viewHolder) {
            is ViewHolder -> {
                val viewItem = item as Item
                viewHolder.title.text = viewItem.item.title
                viewHolder.detail.setText(Html.fromHtml(viewItem.item.detail), TextView.BufferType.SPANNABLE)
            }
        }

//
//        if (convertView == null) {
//            if (position == 0) {
//                vi = inflater.inflate(R.layout.home_header_item, null)
//                viewHolder = HeaderViewHolder()
//                vi.tag = vi
//
//            } else {
//                vi = inflater.inflate(R.layout.main_section, null)
//                viewHolder = ViewHolder()
//                viewHolder.title = vi.findViewById(R.id.title)
//                viewHolder.detail = vi.findViewById(R.id.detail)
//                vi.tag = viewHolder
//            }
//        } else {
//            viewHolder = convertView.tag
//        }
//
//        return when (viewHolder) {
//            is ViewHolder -> {
//                val item = data[position]
//                viewHolder.title.text = item.title
//                viewHolder.detail.setText(Html.fromHtml(item.detail), TextView.BufferType.SPANNABLE)
//                vi!!
//            }
//
//            else -> {
//                vi!!
//            }
//        }
        return vi!!
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}