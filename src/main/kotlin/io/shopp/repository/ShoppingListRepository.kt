package io.shopp.repository

import io.shopp.model.entity.ShoppingListEntity
import org.springframework.data.mongodb.repository.MongoRepository

interface ShoppingListRepository : MongoRepository<ShoppingListEntity, String> {
}
