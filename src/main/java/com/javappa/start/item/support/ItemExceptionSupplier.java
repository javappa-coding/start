package com.javappa.start.item.support;

import com.javappa.start.item.support.exception.ItemNotFoundException;
import java.util.function.Supplier;

public class ItemExceptionSupplier {

    public static Supplier<ItemNotFoundException> itemNotFound(Long id) {
        return () -> new ItemNotFoundException(id);
    }
}