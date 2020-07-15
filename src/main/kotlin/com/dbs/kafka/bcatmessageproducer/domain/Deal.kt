package com.dbs.kafka.bcatmessageproducer.domain

import javax.persistence.*

@Entity
@Table
class Deal {
    @Id
    @Column(name = "contract_address")
    var contractAddress: String = ""

    @Column(name = "mx_contract_number")
    var mxContractNumber: String = ""

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    var status : DealStatus = DealStatus.CON
}

enum class DealStatus() {
    CON,
    MAT,
    PENDING_CASH,
    CASH_SETTLED,
    SETTLED,
    ERROR
}