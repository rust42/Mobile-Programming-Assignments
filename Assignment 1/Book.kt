open class Book (var title: String, var author: String, var price: Double ){
    open fun read() {
        println("Reading paper book")
        println("$title written by $author")
    }
}

class EBook(title: String, author: String, price: Double, var filetype: String): Book(title, author, price) {

    override fun read() {
        println("Read from electronic device")
        println("$title written by $author, format $filetype")
    }
}


