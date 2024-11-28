package org.techtown.twosomeheart.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResponseMyMenuDto(
    @SerialName("data")
    val data: Data,
    @SerialName("status")
    val status: Int
) {
    @Serializable
    data class Data(
        @SerialName("favoriteList")
        val favoriteList: List<FavoriteList>
    )

    @Serializable
    data class FavoriteList(
        @SerialName("id")
        val id: Long,
        @SerialName("name")
        val name: String,
        @SerialName("price")
        val price: Int,
        @SerialName("imageUrl")
        val imageUrl: String,
        @SerialName("temperature")
        val temperature: String,
        @SerialName("size")
        val size: String,
        @SerialName("coffeeBean")
        val coffeeBean: String,
        @SerialName("togo")
        val togo: String,
        @SerialName("personal")
        val personal: Boolean
    )
}