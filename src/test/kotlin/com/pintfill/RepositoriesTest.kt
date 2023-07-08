package com.pintfill

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
class RepositoriesTests @Autowired constructor(
        val entityManager: TestEntityManager,
        val productRepository: ProductRepository,
        val brandRepository: BrandRepository
) {

    @Test
    fun `When findByIdOrNull then return Product`() {
        val lokal = Brand("Lokal", "University students favourite beer")
        entityManager.persist(lokal)
        val product = Product("Lokal litrão", 3.99, "Great when freezing cold", lokal)
        entityManager.persist(product)
        entityManager.flush()
        val found = productRepository.findByIdOrNull(product.id!!)
        assertThat(found).isEqualTo(product)
    }

    @Test
    fun `When findByLogin then return Brand`() {
        val lokal = Brand("Lokal", "University students favourite beer")
        entityManager.persist(lokal)
        entityManager.flush()
        val brand = brandRepository.findByName(lokal.name)
        assertThat(brand).isEqualTo(lokal)
    }
}