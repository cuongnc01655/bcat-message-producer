package com.dbs.kafka.bcatmessageproducer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BcatMessageProducerApplication

fun main(args: Array<String>) {
	runApplication<BcatMessageProducerApplication>(*args)
}
