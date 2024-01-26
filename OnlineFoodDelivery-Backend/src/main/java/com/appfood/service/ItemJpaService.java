package com.appfood.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.appfood.model.Item;
import com.appfood.repository.ItemJpaRepository;
import com.appfood.repository.ItemRepository;


@Service
public class ItemJpaService implements ItemRepository 
{
	@Autowired
	private ItemJpaRepository itemJpaRepository;
	
	@Override
   	public ArrayList<Item> getItem() 
   	{
   		List<Item> itemList=itemJpaRepository.findAll();
   		ArrayList<Item> items=new ArrayList<>(itemList);
   		return items;
   	}

   	@Override
   	public Item getItemById(int itemId) 
   	{
   		try
   		{
   			Item item=itemJpaRepository.findById(itemId).get();
   			return item;
   		}
   		catch(Exception e)
   		{
   			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
   		}
   		
   	}
   	
   	@Override
   	public Item addItem(Item item) 
   	{
   		itemJpaRepository.save(item);
   	      return item;
   	}
   	

   	@Override
   	public Item updateItem(int itemId, Item item) 
   	{
   		try
   		{
   			Item existingItem=itemJpaRepository.findById(itemId).get();
   			if(item.getItemName()!=null)
   			{
   				existingItem.setItemName(item.getItemName());
   			}
   			if(item.getQuantity()!=0)
   			{
   			   existingItem.setQuantity(item.getQuantity());	
   			}
   			
   		 return itemJpaRepository.save(existingItem);
   			
   			
   		}
   		catch(Exception e)
   		{
   			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
   		}	
   	}

   	@Override
   	public void deleteItem(int itemId) 
   	{
   		try
   		{
   			Item item=itemJpaRepository.findById(itemId).get();
   			if(item!=null)
   			{
   				itemJpaRepository.deleteById(itemId);
   			}
   		}
   		catch(Exception e)
   		{
   			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
   		}
   	}
	


}
