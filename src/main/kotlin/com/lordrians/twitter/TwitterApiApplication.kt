package com.lordrians.twitter

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TwitterApiApplication

fun main(args: Array<String>) {
	runApplication<TwitterApiApplication>(*args)
}
