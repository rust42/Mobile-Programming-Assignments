package edu.miu.cs473.cvbuilder

import android.app.Activity
import android.app.Instrumentation.ActivityResult
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {
    private val activityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK) {
            val resultIntent = it.data
            val item = resultIntent?.getParcelableExtra<HomeItem>(AddCareerItem.resultItemKey)
            item?.let { homeItem ->
                homeItems.add(HomeItemsAdapter.Item(homeItem))
                adapter.notifyDataSetChanged()
            }
        }
    }

    private val homeItems =  mutableListOf<HomeItemsAdapter.HomeAdapterItem>(HomeItemsAdapter.Header())
    private var listView: ListView? = null
    private lateinit var adapter: HomeItemsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeItems.addAll(HomeItem.all.map { HomeItemsAdapter.Item(it) })
        val view = super.onCreateView(inflater, container, savedInstanceState)

        listView = view?.findViewById<ListView>(R.id.listView)
        adapter = HomeItemsAdapter(this.requireContext(), homeItems)
        listView?.adapter = adapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val floatingButton = view.findViewById<FloatingActionButton>(R.id.add_item_button)
        floatingButton?.setOnClickListener(this::onAddItemClick)
    }

    private fun onAddItemClick(view: View) {
        val intent = Intent(requireContext(), AddCareerItem::class.java)
        activityResult.launch(intent)
    }
}