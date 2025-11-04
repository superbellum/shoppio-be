package io.shopp.model.entity

import io.shopp.model.common.Status
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class ShoppingList(
    @Id
    var id: String? = null,
    val title: String,
    val description: String?,
    val status: Status,
    val dateCreated: String,
    val dueDate: String?,
)
