package io.shopp.service

import io.shopp.model.payload.request.CreateShoppingListRequest
import io.shopp.model.payload.request.PatchShoppingListRequest
import io.shopp.model.payload.response.ShoppingListResponse
import io.shopp.repository.ShoppingListItemRepository
import io.shopp.repository.ShoppingListRepository
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class ShoppingListService(
    private val shoppingListRepository: ShoppingListRepository,
    private val shoppingListItemRepository: ShoppingListItemRepository
) {
    fun getAllShoppingLists(withItems: Boolean): ResponseEntity<List<ShoppingListResponse>> {
        val shoppingLists = shoppingListRepository.findAll()
        var shoppingListResponses = shoppingLists.map { it.toResponse() }

        if (withItems) {
            shoppingListResponses = shoppingListResponses.map {
                it.apply {
                    items = shoppingListItemRepository.findAllByShoppingListId(id).map { it.toResponse() }
                }
            }
        }

        return ResponseEntity.ok(shoppingListResponses)
    }

    fun getShoppingListById(id: String, withItems: Boolean): ResponseEntity<ShoppingListResponse> {
        val shoppingList = shoppingListRepository.findById(id)
            .orElseThrow { ResponseStatusException(NOT_FOUND, "Shopping list with id '$id' not found") }

        return ResponseEntity.ok(
            shoppingList.toResponse()
                .apply {
                    if (withItems) {
                        items = shoppingListItemRepository.findAllByShoppingListId(id).map { it.toResponse() }
                    }
                }
        )
    }

    fun createShoppingList(request: CreateShoppingListRequest): ResponseEntity<ShoppingListResponse> {
        val shoppingList = shoppingListRepository.save(request.toEntity())
        return ResponseEntity.ok(shoppingList.toResponse())
    }

    fun patchShoppingList(id: String, request: PatchShoppingListRequest): ResponseEntity<ShoppingListResponse> {
        val shoppingList = shoppingListRepository.findById(id)
            .orElseThrow { ResponseStatusException(NOT_FOUND, "Shopping list with id '$id' not found") }

        val updatedShoppingList = shoppingList.copy(
            title = request.title ?: shoppingList.title,
            description = request.description ?: shoppingList.description,
            dueDate = request.dueDate ?: shoppingList.dueDate,
            status = request.status ?: shoppingList.status
        )

        val savedShoppingList = shoppingListRepository.save(updatedShoppingList)
        return ResponseEntity.ok(savedShoppingList.toResponse())
    }

    fun deleteAllShoppingLists(): ResponseEntity<String> {
        shoppingListRepository.deleteAll()
        return ResponseEntity.ok("Deleted all shopping lists")
    }

    fun deleteShoppingListById(id: String): ResponseEntity<String> {
        if (shoppingListRepository.existsById(id)) {
            shoppingListRepository.deleteById(id)
            return ResponseEntity.ok("Deleted shopping list with id '$id'")
        } else {
            throw ResponseStatusException(NOT_FOUND, "Shopping list with id '$id' not found")
        }
    }
}
