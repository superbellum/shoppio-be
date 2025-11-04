package io.shopp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.mongodb.config.EnableMongoAuditing

@SpringBootApplication
@EnableMongoAuditing
class ShoppApplication

fun main(args: Array<String>) {
	runApplication<ShoppApplication>(*args)
}
