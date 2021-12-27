package com.example.lstore.model

import java.io.Serializable

data class Product(

    var productName: String?,
    var productFixedValue: String,
    var productOfferValue: String,
    var productImage: Int

): Serializable {
    var id: Int? = null
}
