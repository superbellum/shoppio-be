package io.shopp.repository

import io.shopp.model.entity.ShoppingList
import org.springframework.data.mongodb.repository.MongoRepository

interface ShoppingListRepository : MongoRepository<ShoppingList, String> {
}
