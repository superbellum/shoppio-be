package io.shopp.model.entity

import io.shopp.model.common.Priority
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
    val description: String?,
    val link: String?,
    val imageUrl: String,
    val status: Status,
    val priority: Priority,
    @CreatedDate
    val createdDate: Instant? = null,
    @LastModifiedDate
    val lastModifiedDate: Instant? = null,
) {
    fun toResponse() = ShoppingListItemResponse(
        id = id!!,
        shoppingListId = shoppingListId,
        name = name,
        description = description,
        link = link,
        imageUrl = imageUrl,
        status = status,
        priority = priority,
        createdDate = createdDate!!,
        lastModifiedDate = lastModifiedDate!!
    )
}
