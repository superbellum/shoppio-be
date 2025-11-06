package io.shopp.model.payload.request

import io.shopp.model.common.Status
import java.time.Instant

data class PatchShoppingListRequest(
    val title: String? = null,
    val description: String? = null,
    val dueDate: Instant? = null,
    val status: Status? = null
)
