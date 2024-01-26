package com.appfood.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.appfood.model.Item;
import com.appfood.service.ItemJpaService;


@RestController
@CrossOrigin
public class ItemController 
{
	@Autowired
	private ItemJpaService itemService;
	
	@GetMapping("/items")
	public ArrayList<Item> getItems()
	{
		return itemService.getItem();
	}
	
	@GetMapping("/items/{itemId}")
	public Item getItemId(@PathVariable int itemId)
	{
		return itemService.getItemById(itemId);
	}
	
	@PostMapping("/items/addnewitem")
	public Item addItem(@RequestBody Item item)
	{
		return itemService.addItem(item);
	}
	
	@PutMapping("/items/{itemId}")
	public Item updateItem(@PathVariable int itemId,@RequestBody Item item)
	{
		return itemService.updateItem(itemId,item);
	}
	
	@DeleteMapping("/items/{itemId}")
	public void deleteItem(@PathVariable int itemId)
	{
		itemService.deleteItem(itemId);
	}
	
	

}
