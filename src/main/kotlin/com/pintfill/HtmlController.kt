package com.pintfill

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class HtmlController(private val repository: ProductRepository) {

    @GetMapping("/")
    fun pintfill(model: Model): String {
        model["title"] = "Pintfill"
        model["products"] = repository.findAllByOrderByAddedAtDesc().map { it.render() }
        return "pintfill"
    }

    @GetMapping("/product/{slug}")
    fun product(model: Model, @PathVariable slug: String): String {
        val product = repository.findBySlug(slug)
                ?.render()
                ?: throw IllegalArgumentException("Wrong product slug provided")
        model["title"] = product.title
        model["product"] = product
        return "product"
    }

    fun Product.render() = RenderedProduct(
            slug,
            title,
            price,
            description,
            brand.name)

    data class RenderedProduct(
            val slug: String,
            val title: String,
            val price: Double,
            val description: String,
            val brand: String)

}