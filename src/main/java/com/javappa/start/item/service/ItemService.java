package com.javappa.start.item.service;

import com.javappa.start.item.api.request.ItemRequest;
import com.javappa.start.item.api.request.UpdateItemRequest;
import com.javappa.start.item.api.response.ItemResponse;
import com.javappa.start.item.domain.Item;
import com.javappa.start.item.repository.ItemRepository;
import com.javappa.start.item.support.ItemExceptionSupplier;
import com.javappa.start.item.support.ItemMapper;
import org.springframework.stereotype.Service;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final ItemMapper itemMapper;

    public ItemService(ItemRepository itemRepository, ItemMapper itemMapper) {
        this.itemRepository = itemRepository;
        this.itemMapper = itemMapper;
    }

    public ItemResponse create(ItemRequest itemRequest) {
        Item item = itemRepository.save(itemMapper.toItem(itemRequest));
        return itemMapper.toItemResponse(item);
    }

    public ItemResponse find(Long id) {
        Item item = itemRepository.findById(id).orElseThrow(ItemExceptionSupplier.itemNotFound(id));
        return itemMapper.toItemResponse(item);
    }

    public ItemResponse update(UpdateItemRequest updateItemRequest) {
        Item item = itemRepository.findById(updateItemRequest.getId()).orElseThrow(
                ItemExceptionSupplier.itemNotFound(updateItemRequest.getId()));
        itemRepository.save(itemMapper.toItem(item, updateItemRequest));
        return itemMapper.toItemResponse(item);
    }

    public ItemResponse updateAlternativeVersion(Long id, UpdateItemRequest updateItemRequest) {
        Item item = itemRepository.findById(id).orElseThrow(
                ItemExceptionSupplier.itemNotFound(id));
        itemRepository.save(itemMapper.toItem(item, updateItemRequest));
        return itemMapper.toItemResponse(item);
    }
}
