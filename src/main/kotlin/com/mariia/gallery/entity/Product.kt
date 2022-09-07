package com.mariia.gallery.entity

import com.mariia.gallery.service.ProductCreateRequest
import java.math.BigDecimal
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name = "product")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,
    var name: String = "",
    var description: String? = "",
    var price: BigDecimal = BigDecimal.ZERO,
    var url: String? = "",
) {

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , description = $description , price = $price , url = $url )"
    }

    fun toDto(): ProductCreateRequest {
        return ProductCreateRequest(
            name = name,
            description = description,
            price = price.toInt(),
            url = url
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product

        if (id != other.id) return false
        if (name != other.name) return false
        if (description != other.description) return false
        if (price != other.price) return false

        return true
    }
}