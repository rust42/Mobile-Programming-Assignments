package edu.miu.cs473.cvbuilder

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ContactFragment: Fragment(R.layout.fragment_contact) {
    private val myPermissionToCall = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        val recyclerView = view?.findViewById<RecyclerView>(R.id.contacts_recycler_view)
        recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        val contacts = ContactItem.all
        recyclerView?.adapter = ContactsRecyclerViewAdapter(ContactItem.all) {
            val contact = contacts[it]
            performClickAction(contact)
        }
        return view
    }

    private fun performClickAction(contact: ContactItem) {
        val context = requireContext()
        when (contact.action) {
            ContactItem.ContactItemAction.OPEN_WEB -> context.openUrl(contact.value)
            ContactItem.ContactItemAction.CALL -> {
                if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.CALL_PHONE)
                    != PackageManager.PERMISSION_GRANTED
                ) {
                    activity?.let {
                        ActivityCompat.requestPermissions(
                            it, arrayOf(Manifest.permission.CALL_PHONE),
                            myPermissionToCall
                        )
                    }
                } else {
                    context.call(contact.value)
                }
            }
            ContactItem.ContactItemAction.EMAIL -> {
                requireContext().sendEmail("sndpkrl007@gmail.com")
            }
            ContactItem.ContactItemAction.VIEW_PDF -> {
                val intent = Intent(requireContext(), PdfViewer::class.java)
                startActivity(intent)
            }
        }
    }
}