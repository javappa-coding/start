package com.javappa.start.item.api;

import com.javappa.start.item.api.request.ItemRequest;
import com.javappa.start.item.api.request.UpdateItemRequest;
import com.javappa.start.item.api.response.ItemResponse;
import com.javappa.start.item.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "Items")
@RequestMapping("/api/items")
public class ItemApi {

    private final ItemService itemService;

    ItemApi(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    @ApiOperation("Create item")
    public ResponseEntity<ItemResponse> create(@RequestBody ItemRequest itemRequest) {
        ItemResponse itemResponse = itemService.create(itemRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(itemResponse);
    }

    @GetMapping("/{id}")
    @ApiOperation("Find item")
    public ResponseEntity<ItemResponse> find(@PathVariable Long id) {
        ItemResponse itemResponse = itemService.find(id);
        return ResponseEntity.status(HttpStatus.OK).body(itemResponse);
    }

    @PutMapping
    @ApiOperation("Update item")
    public ResponseEntity<ItemResponse> update(@RequestBody UpdateItemRequest updateItemRequest) {
        ItemResponse itemResponse = itemService.update(updateItemRequest);
        return ResponseEntity.status(HttpStatus.OK).body(itemResponse);
    }

    @PutMapping("/{id}")
    @ApiOperation("Update item alternative version")
    /** Wersja alternatywna. Id przekazujemy w parametrze ścieżki (@PathVariable).
     *  Jest to nawet bardziej zgodne z ideą REST Api (jawna informacja o identyfikatorze modyfikowanego zasobu),
     *  natomiast zdarza się, że niektóre komponenty Javascipt wymagają wstawienia id w body.
     *  Takie podejście (przez body) jest bardziej elastyczne i dlatego pokazaliśmy je na filmie.
     * */
    public ResponseEntity<ItemResponse> update(@PathVariable Long id, @RequestBody UpdateItemRequest updateItemRequest) {
        ItemResponse itemResponse = itemService.updateAlternativeVersion(id, updateItemRequest);
        return ResponseEntity.status(HttpStatus.OK).body(itemResponse);
    }

    @GetMapping
    @ApiOperation("Find all items")
    public ResponseEntity<List<ItemResponse>> findAll() {
        List<ItemResponse> itemResponses = itemService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(itemResponses);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Delete item")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        itemService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}