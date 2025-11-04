package io.shopp.model.entity

import io.shopp.model.common.Status
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class ShoppingListItem(
    @Id
    var id: String? = null,
    val shoppingListId: String,
    val name: String,
    val link: String?,
    val imageData: String?,
    val status: Status,
)
