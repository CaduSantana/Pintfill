package com.pintfill

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PintfillApplication

fun main(args: Array<String>) {
    runApplication<PintfillApplication>(*args){
        setBannerMode(Banner.Mode.OFF)
    }
}
