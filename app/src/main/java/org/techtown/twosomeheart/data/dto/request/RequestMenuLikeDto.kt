package org.techtown.twosomeheart.data.dto.request

import kotlinx.serialization.Serializable

@Serializable
data class RequestMenuLikeDto(
    val name: String,
    val price: Int,
    val temperature: Int,
    val size: Int,
    val coffeeBean: Int,
    val togo: Int,
    val personal: Boolean
)