package com.appfood.repository;

import java.util.ArrayList;
import com.appfood.model.Item;

public interface ItemRepository 
{
	ArrayList<Item> getItem();
	Item getItemById(int itemId);
	Item addItem(Item item);
	Item updateItem(int itemId, Item item);
	void deleteItem(int itemId);
}
