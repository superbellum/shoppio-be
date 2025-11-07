package io.shopp.controller

import io.shopp.model.payload.request.CreateShoppingListItemRequest
import io.shopp.model.payload.request.PatchShoppingListItemRequest
import io.shopp.service.ShoppingListItemService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/shopping-list")
class ShoppingListItemController(private val shoppingListItemService: ShoppingListItemService) {
    @GetMapping("{shoppingListId}/items")
    fun getItemsForShoppingList(@PathVariable shoppingListId: String) =
        shoppingListItemService.getItemsForShoppingList(shoppingListId)

    @PostMapping("{shoppingListId}/items")
    fun createShoppingListItem(
        @PathVariable shoppingListId: String,
        @RequestBody request: CreateShoppingListItemRequest
    ) = shoppingListItemService.createShoppingListItem(shoppingListId, request)

    @PatchMapping("{shoppingListId}/items/{itemId}")
    fun patchShoppingListItem(
        @PathVariable shoppingListId: String,
        @PathVariable itemId: String,
        @RequestBody request: PatchShoppingListItemRequest
    ) = shoppingListItemService.patchShoppingListItem(shoppingListId, itemId, request)

    @DeleteMapping("{shoppingListId}/items")
    fun deleteAllItemsForShoppingList(@PathVariable shoppingListId: String) =
        shoppingListItemService.deleteAllItemsForShoppingList(shoppingListId)

    @DeleteMapping("{shoppingListId}/items/{itemId}")
    fun deleteItemById(
        @PathVariable shoppingListId: String,
        @PathVariable itemId: String,
    ) = shoppingListItemService.deleteItemById(shoppingListId, itemId)
}
