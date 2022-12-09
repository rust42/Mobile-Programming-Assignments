package edu.miu.cs473.cvbuilder

data class ContactItem(val value: String, val detail: String, val image: Int, val action: ContactItemAction) {
    enum class ContactItemAction {
        CALL,
        EMAIL,
        OPEN_WEB,
        VIEW_PDF,
    }
    companion object {
        val all: Array<ContactItem>
        get() = arrayOf(
            ContactItem("+1 (641) 819-2553", "Mobile", R.drawable.phone_icon, ContactItemAction.CALL),
            ContactItem("sandeep.koiralaa@gmail.com", "Email", R.drawable.email_icon, ContactItemAction.EMAIL),
            ContactItem("https://www.linkedin.com/in/sandeepkoirala/", "LinkedIn Website", R.drawable.linkedin_icon, ContactItemAction.OPEN_WEB),
            ContactItem("https://www.github.com/rust42", "Github", R.drawable.github_icon, ContactItemAction.OPEN_WEB),
            ContactItem("PDF", "Resume pdf", R.drawable.pdf_icon, ContactItemAction.VIEW_PDF)
        )
    }
}