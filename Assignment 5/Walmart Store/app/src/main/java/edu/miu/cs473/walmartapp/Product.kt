package edu.miu.cs473.walmartapp

import android.os.Parcel
import android.os.Parcelable

data class Product (val title: String,
                    val price: Double,
                    val color: String,
                    val image: String,
                    val itemId: Int,
                    val desc: String): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()?:"",
        parcel.readDouble(),
        parcel.readString()?:"",
        parcel.readString()?:"",
        parcel.readInt(),
        parcel.readString()?:""
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeDouble(price)
        parcel.writeString(color)
        parcel.writeString(image)
        parcel.writeInt(itemId)
        parcel.writeString(desc)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
};