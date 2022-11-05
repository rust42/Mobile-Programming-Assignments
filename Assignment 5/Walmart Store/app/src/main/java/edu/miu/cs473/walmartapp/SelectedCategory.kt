package edu.miu.cs473.walmartapp

enum class SelectedCategory(val value: Int) {
    Electronics(1),
    Clothing(2),
    Beauty(3),
    Food(4);

    companion object  {
        fun fromInt(value: Int) = SelectedCategory.values().first { it.value == value }
    }

    val title: String
    get() =  when (this) {
        Electronics -> "Electronics";
        Clothing -> "Clothing";
        Beauty -> "Beauty";
        Food -> "Food";
    }
}
