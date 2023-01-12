package net.yorksolutions.zachrauchpantrybe.services;

import net.yorksolutions.zachrauchpantrybe.models.Items;
import net.yorksolutions.zachrauchpantrybe.repositories.ItemsRepository;
import org.springframework.stereotype.Service;

@Service
public class ItemsService {

    final ItemsRepository itemsRepository;

    public ItemsService(ItemsRepository itemsRepository) {
        this.itemsRepository = itemsRepository;
    }

    public Items addItems(Items items) throws Exception{
        if (itemsRepository.findByNameAndUserId(items.name, items.userId).isPresent()) {
            throw new Exception("The item you entered already exists");
        }
        return this.itemsRepository.save(items);
    }

    public void deleteItem(Long id) throws Exception {
        if (itemsRepository.existsById(id)) {
            itemsRepository.deleteById(id);
        } else throw new Exception("Item not found");
    }

    public Items updateItem(Long id, Items items) throws Exception {
        if (itemsRepository.existsById(id)) {
            return itemsRepository.save(items);
        } else throw new Exception("Invalid item");
    }

    public Iterable<Items> getItemsByUserId(Long userId) {
        return itemsRepository.findByUserId(userId);
    }
}
