package io.shopp.repository

import io.shopp.model.entity.ShoppingListItem
import org.springframework.data.mongodb.repository.MongoRepository

interface ShoppingListItemRepository : MongoRepository<ShoppingListItem, String> {
    fun findAllByShoppingListId(shoppingListId: String): List<ShoppingListItem>
}
