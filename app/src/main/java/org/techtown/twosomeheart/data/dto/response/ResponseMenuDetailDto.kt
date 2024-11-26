package org.techtown.twosomeheart.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseMenuDetailDto(
    @SerialName("data")
    val menuDetail: MenuDetail,
    @SerialName("status")
    val status: Int
) {
    @Serializable
    data class MenuDetail(
        @SerialName("allergy")
        val allergy: String,
        @SerialName("caution")
        val caution: String,
        @SerialName("description")
        val description: String,
        @SerialName("id")
        val id: Long,
        @SerialName("image_url")
        val imageUrl: String,
        @SerialName("name")
        val name: String,
        @SerialName("nutrition")
        val nutrition: String,
        @SerialName("price")
        val price: Int,
        @SerialName("status")
        val status: String
    )
}
