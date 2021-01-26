package com.javappa.start.item.support;

import com.javappa.start.item.api.request.ItemRequest;
import com.javappa.start.item.api.response.ItemResponse;
import com.javappa.start.item.domain.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public Item toItem(ItemRequest itemRequest) {
        return new Item(itemRequest.getName());
    }

    public ItemResponse toItemResponse(Item item) {
        return new ItemResponse(item.getId(), item.getName());
    }
}
