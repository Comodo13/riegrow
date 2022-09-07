package com.mariia.gallery.service

import com.mariia.gallery.db.ProductRepository
import com.mariia.gallery.entity.Product
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository,
) {


    fun createProduct(request: ProductCreateRequest): Product {
        return productRepository.save(
            Product(
                name = request.name,
                description = request.description,
                price = request.price.toBigDecimal(),
            )
        )
    }

    fun getById(id: Long) = productRepository.findById(id).get()

    fun deleteById(id: Long) = productRepository.deleteById(id)

    fun getAllProducts() = productRepository.findAll()

    fun editById(id: Long, request: ProductCreateRequest) = productRepository.findByIdOrNull(id)


}

data class ProductCreateRequest(
    val name: String,
    val description: String?,
    val price: Int,
    val url: String?
)