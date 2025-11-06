package io.shopp.controller

import io.shopp.model.payload.request.CreateShoppingListRequest
import io.shopp.model.payload.request.PatchShoppingListRequest
import io.shopp.service.ShoppingListService
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
class ShoppingListController(
    private val shoppingListService: ShoppingListService
) {
    @GetMapping
    fun getAllShoppingLists() = shoppingListService.getAllShoppingLists()

    @GetMapping("{id}")
    fun getShoppingListById(@PathVariable id: String) =
        shoppingListService.getShoppingListById(id)

    @PostMapping
    fun createShoppingList(@RequestBody request: CreateShoppingListRequest) =
        shoppingListService.createShoppingList(request)

    @PatchMapping("{id}")
    fun patchShoppingList(@PathVariable id: String, @RequestBody request: PatchShoppingListRequest) =
        shoppingListService.patchShoppingList(id, request)

    @DeleteMapping
    fun deleteAllShoppingLists() =
        shoppingListService.deleteAllShoppingLists()

    @DeleteMapping("{id}")
    fun deleteShoppingListById(@PathVariable id: String) =
        shoppingListService.deleteShoppingListById(id)
}
