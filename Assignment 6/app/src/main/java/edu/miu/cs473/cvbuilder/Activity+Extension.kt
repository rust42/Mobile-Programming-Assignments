package edu.miu.cs473.cvbuilder

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast


fun Context.openUrl(url: String, action: String = Intent.ACTION_VIEW, type: String? = null,) {
    val intent = Intent(action)
    intent.data = Uri.parse(url)
    type?.let {
        intent.type = it
    }
    startIntentActivity(intent)
}

fun Context.call(phoneNumber: String) {
    val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$phoneNumber"))
    startIntentActivity(intent)
}

fun Context.sendEmail(emailAddress: String) {
    val emailIntent = Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", emailAddress, null))
    startActivity(Intent.createChooser(emailIntent, "Choose mail"))

}

private fun Context.startIntentActivity(intent: Intent) {
    try {
//        val resolveInfo =
//            packageManager.resolveActivity(intent, PackageManager.MATCH_DEFAULT_ONLY)
//        if (resolveInfo != null) {
            startActivity(intent)
//        } else {
//            throw  ActivityNotFoundException()
//        }
    } catch(ex: ActivityNotFoundException) {
        println("Exception occurred:  $ex")
        Toast.makeText(this, "Could not start intent", Toast.LENGTH_SHORT)
            .show()
    }
}
