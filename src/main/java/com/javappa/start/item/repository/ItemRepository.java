package com.javappa.start.item.repository;

import com.javappa.start.item.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

}
