package com.dbs.kafka.bcatmessageproducer.domain

import java.math.BigInteger
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "bonds")
class Bond {
    @Id
    @Column
    var isin: String = ""

    @Column
    var description: String = ""

    @Column(name = "issuance_quantity")
    var issuanceQuantity: BigInteger = BigInteger.ZERO
}