package io.shopp.repository

import io.shopp.model.entity.ShoppingListItemEntity
import org.springframework.data.mongodb.repository.MongoRepository

interface ShoppingListItemRepository : MongoRepository<ShoppingListItemEntity, String> {
    fun findAllByShoppingListId(shoppingListId: String): List<ShoppingListItemEntity>

    fun deleteAllByShoppingListId(shoppingListId: String)

    fun existsByIdAndShoppingListId(itemId: String, shoppingListId: String): Boolean
}
