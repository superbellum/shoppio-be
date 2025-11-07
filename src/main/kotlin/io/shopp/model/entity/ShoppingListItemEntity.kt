package io.shopp.model.entity

import io.shopp.model.common.Status
import io.shopp.model.payload.response.ShoppingListItemResponse
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document
data class ShoppingListItemEntity(
    @Id
    var id: String? = null,
    val shoppingListId: String,
    val name: String,
    val link: String?,
    val imageData: String?,
    val status: Status,
    @CreatedDate
    val createdDate: Instant? = null,
    @LastModifiedDate
    val lastModifiedDate: Instant? = null,
) {
    fun toResponse() = ShoppingListItemResponse(
        id = id!!,
        shoppingListId = shoppingListId,
        name = name,
        link = link,
        imageData = imageData,
        status = status,
        createdDate = createdDate!!,
        lastModifiedDate = lastModifiedDate!!
    )
}
