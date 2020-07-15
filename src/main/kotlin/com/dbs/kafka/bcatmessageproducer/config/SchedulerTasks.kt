package com.dbs.kafka.bcatmessageproducer.config

import com.dbs.kafka.bcatmessageproducer.domain.DealStatus
import com.dbs.kafka.bcatmessageproducer.domain.DealStatus.SETTLED
import com.dbs.kafka.bcatmessageproducer.repositories.BondRepository
import com.dbs.kafka.bcatmessageproducer.repositories.DealRepository
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class ScheduledTasks(
        private val bondRepository: BondRepository,
        private val dealRepository: DealRepository,
        private val kafkaTemplate: KafkaTemplate<String, String>
) {

    @Scheduled(fixedRate = 30000)
    fun bookDeals() {
        val bond = bondRepository.findAll().first()
        val deal = String.format(dealTemplate(), bond.isin, "MX${dealRepository.count() + 1}")
        kafkaTemplate.send("deal-topic", "")
    }

    @Scheduled(fixedRate = 30000)
    fun settleCash() {
        val pendingDeals = dealRepository.findByStatusNot(SETTLED)
        pendingDeals.forEach {
            val message = String.format(cashSettledTemplate(), it.mxContractNumber)
            kafkaTemplate.send("cash-settled-topic", message)
        }
    }

    fun dealTemplate() = """
        <xml>
            <isin>{0}</isin>
            <contract>{1}</contract>
        </xml>
    """.trimIndent()

    fun cashSettledTemplate() = """
        {
            "mxContractNumber": {0}
        }
    """.trimIndent()
}