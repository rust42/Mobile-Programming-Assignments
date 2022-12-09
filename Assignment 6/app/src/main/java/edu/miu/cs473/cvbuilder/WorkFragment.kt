package edu.miu.cs473.cvbuilder

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WorkFragment: Fragment(R.layout.fragment_work) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.works_recycler_view)
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        recyclerView?.adapter = WorksRecyclerViewAdapter(WorkItem.all)
        return view
    }
}