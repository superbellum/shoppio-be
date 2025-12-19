package io.shopp.model.payload.response

import io.shopp.model.common.Priority
import io.shopp.model.common.Status
import java.time.Instant

data class ShoppingListItemResponse(
    val id: String,
    val shoppingListId: String,
    val name: String,
    val description: String?,
    val link: String?,
    val imageUrl: String,
    val status: Status,
    val priority: Priority,
    val createdDate: Instant,
    val lastModifiedDate: Instant,
)
