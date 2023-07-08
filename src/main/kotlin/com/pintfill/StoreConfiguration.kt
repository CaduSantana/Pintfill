package com.pintfill

import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class StoreConfiguration {

    @Bean
    fun databaseInitializer(brandRepository: BrandRepository,
                            productRepository: ProductRepository) = ApplicationRunner {

        val eisenbahn = brandRepository.save(Brand("Eisenbahn", "Cerveja de alta fermentação"))
        productRepository.save(Product(
                title = "Eisenbahn long neck",
                price = 7.99,
                description = "Garrafa de 355ml",
                brand = eisenbahn
        ))
        productRepository.save(Product(
                title = "Eisenbahn long neck",
                price = 7.99,
                description = "Garrafa de 355ml",
                brand = eisenbahn
        ))
    }
}