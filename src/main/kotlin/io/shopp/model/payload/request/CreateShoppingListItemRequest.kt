package io.shopp.model.payload.request

import io.shopp.model.common.Priority
import io.shopp.model.common.Status
import io.shopp.model.entity.ShoppingListItemEntity

data class CreateShoppingListItemRequest(
    val name: String,
    val link: String?,
    val imageUrl: String?,
    val priority: Priority,
) {
    fun toEntity(shoppingListId: String) = ShoppingListItemEntity(
        shoppingListId = shoppingListId,
        name = name,
        link = link,
        imageUrl = imageUrl,
        status = Status.OPEN,
        priority = priority,
    )
}
