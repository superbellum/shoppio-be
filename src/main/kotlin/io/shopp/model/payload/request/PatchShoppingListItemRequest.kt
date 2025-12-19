package io.shopp.model.payload.request

import io.shopp.model.common.Priority
import io.shopp.model.common.Status

data class PatchShoppingListItemRequest(
    val name: String? = null,
    val description: String? = null,
    val link: String? = null,
    val imageUrl: String? = null,
    val status: Status? = null,
    val priority: Priority? = null,
)
