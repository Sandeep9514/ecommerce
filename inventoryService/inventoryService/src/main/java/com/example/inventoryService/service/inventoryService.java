package com.example.inventoryService.service;

import com.example.inventoryService.entity.item;
import com.example.inventoryService.repository.inventoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class inventoryService {

    private inventoryRepo repo;
    public inventoryService(inventoryRepo repo) {
        this.repo = repo;
    }

    public List<item> get_all() {
        return repo.findAll();
    }

    public item get_byid(int prodId) {
        return repo.getReferenceById(prodId);
    }

    public item post_prod(item prod) {
        return repo.save(prod);
    }

    public List<item> delete_byid(int prodId) {
        item temp = get_byid(prodId);
        if(temp != null){
            repo.deleteById(prodId);
        }
        return get_all();
    }

    public List<item> put_byid(item prod) {
        item temp = get_byid(prod.getItemId());
        if(temp != null){
            temp.setAvailableUnits(prod.getAvailableUnits());
            temp.setPrice(prod.getPrice());
            temp.setRating(prod.getRating());
            temp.setItemName(prod.getItemName());
            repo.save(temp);
        }
        return get_all();
    }

    /*public List<item> search(String prodInfo) {
        return repo.
    }*/
}
