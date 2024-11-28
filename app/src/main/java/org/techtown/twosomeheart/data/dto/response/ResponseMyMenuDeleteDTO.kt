package org.techtown.twosomeheart.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseMyMenuDeleteDTO(
    @SerialName("status")
    val status: Int
)