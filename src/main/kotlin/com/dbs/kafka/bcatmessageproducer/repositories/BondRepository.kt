package com.dbs.kafka.bcatmessageproducer.repositories

import com.dbs.kafka.bcatmessageproducer.domain.Bond
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BondRepository: JpaRepository<Bond, String> {
}