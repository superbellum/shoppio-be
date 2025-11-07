package io.shopp.service

import io.shopp.model.payload.request.CreateShoppingListItemRequest
import io.shopp.model.payload.request.PatchShoppingListItemRequest
import io.shopp.model.payload.response.ShoppingListItemResponse
import io.shopp.repository.ShoppingListItemRepository
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ShoppingListItemService(private val shoppingListItemRepository: ShoppingListItemRepository) {
    fun getItemsForShoppingList(shoppingListId: String): ResponseEntity<List<ShoppingListItemResponse>> {
        val shoppingListItems = shoppingListItemRepository.findAllByShoppingListId(shoppingListId)
        return ResponseEntity.ok(shoppingListItems.map { it.toResponse() })
    }

    fun createShoppingListItem(
        shoppingListId: String,
        request: CreateShoppingListItemRequest
    ): ResponseEntity<ShoppingListItemResponse> {
        val shoppingListItem = shoppingListItemRepository.save(request.toEntity(shoppingListId))
        return ResponseEntity.ok(shoppingListItem.toResponse())
    }

    fun patchShoppingListItem(
        shoppingListId: String,
        itemId: String, request:
        PatchShoppingListItemRequest
    ): ResponseEntity<ShoppingListItemResponse> {
        val shoppingListItem = shoppingListItemRepository.findById(itemId)
            .orElseThrow { ResponseStatusException(NOT_FOUND, "Shopping list item with id '$itemId' not found") }

        if (shoppingListItem.shoppingListId != shoppingListId) {
            throw ResponseStatusException(BAD_REQUEST, "Wrong id for shopping list provided")
        }

        val updatedItem = shoppingListItem.copy(
            name = request.name ?: shoppingListItem.name,
            link = request.link ?: shoppingListItem.link,
            imageData = request.imageData ?: shoppingListItem.imageData,
            status = request.status ?: shoppingListItem.status,
        )

        val savedItem = shoppingListItemRepository.save(updatedItem)
        return ResponseEntity.ok(savedItem.toResponse())
    }

    fun deleteAllItemsForShoppingList(shoppingListId: String): ResponseEntity<String> {
        shoppingListItemRepository.deleteAllByShoppingListId(shoppingListId)
        return ResponseEntity.ok("Deleted all shopping list items for list '$shoppingListId")
    }

    fun deleteItemById(shoppingListId: String, itemId: String): ResponseEntity<String> {
        if (shoppingListItemRepository.existsByIdAndShoppingListId(itemId, shoppingListId)) {
            shoppingListItemRepository.deleteById(itemId)
            return ResponseEntity.ok("Deleted shopping list item with id '$itemId'")
        } else {
            throw ResponseStatusException(NOT_FOUND, "Shopping list item not found")
        }
    }
}
