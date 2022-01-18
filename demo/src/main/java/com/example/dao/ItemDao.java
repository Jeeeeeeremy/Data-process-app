package com.example.dao;

import com.example.entity.Item;

import java.util.List;

public interface ItemDao {
    public boolean isExist(Item item);

    public List<Item> QueryAll();

    public Item QueryItemById(Item item);

    public int AddItem(Item item);

    public int UpdateItemById(Item item);

    public int DeleteItemById(int id);
}
