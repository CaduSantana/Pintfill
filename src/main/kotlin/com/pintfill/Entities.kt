package com.pintfill

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.ManyToOne
import org.springframework.data.annotation.Id
import java.time.LocalDateTime

@Entity
class Product(
        @jakarta.persistence.Id @Id var title: String,
        var price : Double,
        var description: String,
        @ManyToOne var brand: Brand,
        var slug: String = title.toSlug(),
        var addedAt: LocalDateTime = LocalDateTime.now(),
)

@Entity
class Brand(
        @jakarta.persistence.Id @Id var name: String,
        var description: String? = null,
)