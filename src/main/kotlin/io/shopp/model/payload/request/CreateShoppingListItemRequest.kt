package io.shopp.model.payload.request

import io.shopp.model.common.Status
import io.shopp.model.entity.ShoppingListItemEntity

data class CreateShoppingListItemRequest(
    val name: String,
    val link: String?,
    val imageData: String?
) {
    fun toEntity(shoppingListId: String) = ShoppingListItemEntity(
        shoppingListId = shoppingListId,
        name = name,
        link = link,
        imageData = imageData,
        status = Status.OPEN,
    )
}
