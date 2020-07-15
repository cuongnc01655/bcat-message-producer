package com.dbs.kafka.bcatmessageproducer.config

import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory

@Configuration
class KafkaProducer {
    @Autowired lateinit var kafkaConfig: KafkaConfig

    @Bean
    fun kafkaTemplate(): KafkaTemplate<String, String> {
        return KafkaTemplate(producerFactory())
    }

    fun producerFactory(): ProducerFactory<String, String> {
        val props = mapOf(
                ProducerConfig.BOOTSTRAP_SERVERS_CONFIG to kafkaConfig.brokerAddress,
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java.name,
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG to StringSerializer::class.java.name
        )
        return DefaultKafkaProducerFactory(props)
    }
}