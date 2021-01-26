package com.javappa.start.item.api;

import com.javappa.start.item.api.request.ItemRequest;
import com.javappa.start.item.api.response.ItemResponse;
import com.javappa.start.item.domain.Item;
import com.javappa.start.item.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemApi {

    private final ItemService itemService;

    ItemApi(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping
    public ResponseEntity<ItemResponse> create(@RequestBody ItemRequest itemRequest) {
        ItemResponse itemResponse = itemService.create(itemRequest);
        return new ResponseEntity<>(itemResponse, HttpStatus.CREATED);
    }
}
