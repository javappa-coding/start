package com.javappa.start.item.api;

import com.javappa.start.item.api.request.ItemRequest;
import com.javappa.start.item.api.response.ItemResponse;
import com.javappa.start.item.service.ItemService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

}
