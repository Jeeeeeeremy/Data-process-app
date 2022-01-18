package com.example.service;

import com.example.entity.Item;

import java.util.List;

public interface ItemService {
    public List<Item> queryallitem();

    public int addItem(Item item);

    public int UpdateItem(Item item);

    public int DeleteItem(Item item);
}
