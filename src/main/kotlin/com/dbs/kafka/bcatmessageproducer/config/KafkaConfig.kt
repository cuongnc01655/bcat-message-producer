package com.dbs.kafka.bcatmessageproducer.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component

@Component
class KafkaConfig(
        @Value("\${kafka.broker.address:localhost:9092}") val brokerAddress: String,
        @Value("\${kafka.group.id:bcat-group") val groupId: String,
        @Value("\${kafka.poll.period:2000}") val pollPeriod: Long
)