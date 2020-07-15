package com.dbs.kafka.bcatmessageproducer.repositories

import com.dbs.kafka.bcatmessageproducer.domain.Deal
import com.dbs.kafka.bcatmessageproducer.domain.DealStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DealRepository: JpaRepository<Deal, String> {
    fun findByMxContractNumber(mxContractNumber: String): Deal?

    fun findByStatusNot(status: DealStatus): List<Deal>
}