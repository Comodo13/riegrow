package com.mariia.gallery.controller


import com.mariia.gallery.service.ProductCreateRequest
import com.mariia.gallery.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/x")
class MainController(
    private val productService: ProductService,
) {

//    @GetMapping("/main")
//    fun mainPage() = productService.getAll()


    @PostMapping("/product")
    fun createProduct(@RequestBody request: ProductCreateRequest): ResponseEntity<ProductCreateRequest> =
        ResponseEntity<ProductCreateRequest>(productService.createProduct(request).toDto(), HttpStatus.MULTI_STATUS)

    @PutMapping("/edit/{id}")
    fun editProduct(@RequestBody request: ProductCreateRequest, @PathVariable id: Long): ResponseEntity<ProductCreateRequest> {
        return ResponseEntity<ProductCreateRequest>(productService.editById(id, request)?.toDto(), HttpStatus.MULTI_STATUS)
    }

    @GetMapping("/all")
    fun getAll(): ResponseEntity<List<ProductCreateRequest>> {
        return ResponseEntity<List<ProductCreateRequest>> (productService.getAllProducts().map { it.toDto() }, HttpStatus.MULTI_STATUS)
    }

    @DeleteMapping("/delete/{id}")
    fun deleteProduct(@PathVariable id: Long) : ResponseEntity<String> {
        productService.deleteById(id)
        return ResponseEntity<String> ("Product was deleted", HttpStatus.MULTI_STATUS)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<ProductCreateRequest> {
        return ResponseEntity<ProductCreateRequest>(productService.getById(id).toDto(), HttpStatus.MULTI_STATUS)
    }
}