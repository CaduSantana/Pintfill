package com.pintfill

import org.springframework.data.repository.CrudRepository

interface ProductRepository : CrudRepository<Product, Long> {
    fun findBySlug(slug: String): Product?
    fun findAllByOrderByAddedAtDesc(): Iterable<Product>
}

interface BrandRepository : CrudRepository<Brand, Long> {
    fun findByName(name: String): Brand?
}