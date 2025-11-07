package io.shopp.model.payload.request

import io.shopp.model.common.Status

data class PatchShoppingListItemRequest(
    val name: String? = null,
    val link: String? = null,
    val imageData: String? = null,
    val status: Status? = null,
)
