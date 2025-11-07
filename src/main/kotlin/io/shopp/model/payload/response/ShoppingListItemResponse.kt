package io.shopp.model.payload.response

import io.shopp.model.common.Status
import java.time.Instant

data class ShoppingListItemResponse(
    val id: String,
    val shoppingListId: String,
    val name: String,
    val link: String?,
    val imageData: String?,
    val status: Status,
    val createdDate: Instant,
    val lastModifiedDate: Instant,
)
