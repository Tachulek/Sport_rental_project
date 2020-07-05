package com.sport.rental.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sport.rental.model.Item;
import com.sport.rental.repository.CategoryRepository;
import com.sport.rental.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public List<Item> getAllItems() {
		List<Item> itemList = itemRepository.findAll();
		return itemList;
	}

	public Item getItem(Integer id) {
		Item item = itemRepository.findAllById(id);
		return item;
	}

	public void removeItem(Integer id) {
		Item item = itemRepository.findAllById(id);
		itemRepository.delete(item);
	}

	public Item saveItem(Item item) {
		return itemRepository.save(item);
	}

	public Item updateItemStatus(Integer itemId, Boolean status) {
		Item item = getItem(itemId);
		item.setIsFree(status);
		itemRepository.save(item);
		return item;
	}

	public List<Item> getAllFreeItems(Integer categoryId) {
		List<Item> itemList = itemRepository
				.findAllByIsFreeAndCategory(true, categoryRepository.findAllById(categoryId));
		return itemList;
	}
}