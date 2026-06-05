package com.example.orderCreationService.controller;

import com.example.orderCreationService.entity.itemDto;
import com.example.orderCreationService.entity.orderInfo;
import org.springframework.web.bind.annotation.*;
import com.example.orderCreationService.service.orderService;

import java.util.List;

@RestController
@RequestMapping("/order")
public class orderController {

    private orderService service;

    public orderController(orderService service) {

        this.service = service;
    }

    @GetMapping("/success")
    public String success() { return "Success"; }

    @GetMapping("/fail")
    public String fail() { return "Unsuccessful"; }

    @GetMapping("/getall")
    public List<itemDto> get_all(){
        return service.get_all();
    }

    @GetMapping("/getbyid/{prodId}")
    public itemDto get_byid(@PathVariable int prodId){
        return service.get_byid(prodId);
    }

    @PostMapping("/prod")
    public itemDto post_prod(@RequestBody itemDto prod){
        return service.post_prod(prod);
    }

    @DeleteMapping("/deletebyid/{prodId}")
    public List<itemDto> delete_byid(@PathVariable int prodId){
        return service.delete_byid(prodId);
    }

    @PutMapping("/prod")
    public List<itemDto> put_byid2(@RequestBody itemDto prod){
        return service.put_byid(prod);
    }

    /*@GetMapping("/search/{prodInfo}")
    public List<itemDto> search(@PathVariable String prodInfo){
        return service.search(prodInfo);
    }*/

    @PostMapping("/orderdata")
    public void create_order(@RequestBody orderInfo orderData){
        service.create_order(orderData);
    }
}
