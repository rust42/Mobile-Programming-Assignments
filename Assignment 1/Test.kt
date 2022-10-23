class Test {

    fun main() {
        val book = Book("To Kill a Mockingbird", "Harper Lee", 7.63)
        book.read()
        book.author = "Harper Alee"

        book.read()

        val eBook = EBook("To Kill a Mockingbird", "Harper Lee", 7.63, "pdf")
        eBook.read()
    }
}

fun main() {
    Test().main()
}