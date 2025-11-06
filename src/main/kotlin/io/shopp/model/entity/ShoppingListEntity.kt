package io.shopp.model.entity

import io.shopp.model.common.Status
import io.shopp.model.payload.response.ShoppingListResponse
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document
data class ShoppingListEntity(
    @Id
    var id: String? = null,
    val title: String,
    val description: String?,
    val status: Status,
    @CreatedDate
    val createdDate: Instant? = null,
    @LastModifiedDate
    val lastModifiedDate: Instant? = null,
    val dueDate: Instant? = null,
) {
    fun toResponse() = ShoppingListResponse(
        id = id!!,
        title = title,
        description = description,
        status = status,
        createdDate = createdDate!!,
        lastModifiedDate = lastModifiedDate!!,
        dueDate = dueDate
    )
}
