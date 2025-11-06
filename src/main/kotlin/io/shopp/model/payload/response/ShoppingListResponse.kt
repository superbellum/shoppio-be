package io.shopp.model.payload.response

import io.shopp.model.common.Status
import java.time.Instant

data class ShoppingListResponse(
    val id: String,
    val title: String,
    val description: String?,
    val status: Status,
    val createdDate: Instant,
    val lastModifiedDate: Instant,
    val dueDate: Instant?,
)
