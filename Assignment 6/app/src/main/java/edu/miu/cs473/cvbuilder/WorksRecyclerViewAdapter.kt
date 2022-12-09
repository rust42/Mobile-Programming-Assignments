package edu.miu.cs473.cvbuilder

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WorksRecyclerViewAdapter(private val items: Array<WorkItem>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    enum class WorkItemType(val value: Int) {
        Header(0),
        Item(1);

        companion object {
            fun fromInt(value: Int): WorkItemType? {
                return when (value) {
                    0 -> Header
                    1 -> Item
                    else -> null
                }
            }
        }
    }

    class WorkItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleField: TextView
        val companyNameField: TextView
        val locationField: TextView
        val fromToDate: TextView
        val descriptionField: TextView
        val companyLogo: ImageView
        val borderView: View

        init {
            titleField = view.findViewById<TextView>(R.id.job_title)
            companyNameField = view.findViewById(R.id.company_name)
            locationField = view.findViewById(R.id.job_location)
            fromToDate = view.findViewById(R.id.job_from_to)
            descriptionField = view.findViewById(R.id.job_description)
            companyLogo = view.findViewById(R.id.company_logo)
            borderView = view.findViewById(R.id.border_view)
        }
    }

    class HeaderItemViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val textView: TextView

        init {
            textView = view.findViewById(R.id.title_header_field)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemType = WorkItemType.fromInt(viewType)
        val inflater = LayoutInflater.from(parent.context)

        return when (itemType) {
            WorkItemType.Header -> HeaderItemViewHolder(inflater.inflate(R.layout.title_header_item, parent, false))
            WorkItemType.Item -> WorkItemViewHolder(inflater.inflate(R.layout.work_item, parent, false))
            else -> throw RuntimeException("Invalid item type")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is WorkItemViewHolder) {
            val workItem = items[position - 1]

            holder.titleField.text = workItem.title
            holder.companyNameField.text = workItem.companyName
            holder.locationField.text = workItem.location
            holder.fromToDate.text = workItem.fromToDate
            holder.descriptionField.text = workItem.description
            holder.companyLogo.setImageResource(workItem.companyLogo)
            holder.borderView.visibility = if (position == items.size) {
                View.GONE
            } else {
                View.VISIBLE
            }
        } else if (holder is HeaderItemViewHolder) {
            holder.textView.text = "Work Experience"
        }
    }

    override fun getItemViewType(position: Int): Int {
        if (position == 0) {
            return WorkItemType.Header.value
        }
        return WorkItemType.Item.value
    }

    override fun getItemCount(): Int {
        return items.size + 1
    }
}