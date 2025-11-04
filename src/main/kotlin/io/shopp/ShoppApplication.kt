package io.shopp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ShoppApplication

fun main(args: Array<String>) {
	runApplication<ShoppApplication>(*args)
}
