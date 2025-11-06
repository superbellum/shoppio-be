package io.shopp.model.payload.request

import io.shopp.model.common.Status
import io.shopp.model.entity.ShoppingListEntity
import java.time.Instant

data class CreateShoppingListRequest(
    val title: String,
    val description: String?,
    val dueDate: Instant?,
) {
    fun toEntity() = ShoppingListEntity(
        title = title,
        description = description,
        dueDate = dueDate,
        status = Status.OPEN
    )
}
