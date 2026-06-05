package com.example.orderCreationService.service;

import com.example.orderCreationService.entity.itemDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(
        name = "inventoryService",
        url = "http://localhost:8082/inventory"
)
public interface inventoryClient {

    @GetMapping("/getall")
    public List<itemDto> get_all();

    @GetMapping("/getbyid/{prodId}")
    public itemDto get_byid(@PathVariable int prodId);

    @PostMapping("/prod")
    public itemDto post_prod(@RequestBody itemDto prod);

    @DeleteMapping("/deletebyid/{prodId}")
    public List<itemDto> delete_byid(@PathVariable int prodId);

    @PutMapping("/prod")
    public List<itemDto> put_byid(@RequestBody itemDto prod);

    /*@GetMapping("/search/{prodInfo}")
    public List<itemDto> search(@PathVariable String prodInfo);*/
}
