package com.example.inventoryService.controller;

import com.example.inventoryService.entity.item;
import com.example.inventoryService.entity.orderDto;
import com.example.inventoryService.entity.paymentDetails;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import com.example.inventoryService.service.inventoryService;
import java.util.List;

@RestController
@RequestMapping("/inventory")
public class inventoryController {

    private inventoryService service;
    private NewTopic topic;
    private KafkaTemplate<String, paymentDetails> kafkaTemplate;

    public inventoryController(inventoryService service, NewTopic topic, KafkaTemplate<String, paymentDetails> kafkaTemplate) {
        this.service = service;
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/getall")
    public List<item> get_all(){
        return service.get_all();
    }

    @GetMapping("/getbyid/{prodId}")
    public item get_byid(@PathVariable int prodId){
        return service.get_byid(prodId);
    }

    @PostMapping("/prod")
    public item post_prod(@RequestBody item prod){
        return service.post_prod(prod);
    }

    @DeleteMapping("/deletebyid/{prodId}")
    public List<item> delete_byid(@PathVariable int prodId){
        return service.delete_byid(prodId);
    }

    @PutMapping("/prod")
    public List<item> put_byid(@RequestBody item prod){
        return service.put_byid(prod);
    }

    /*@GetMapping("/search/{prodInfo}")
    public List<item> search(@PathVariable String prodInfo){
        return service.search(prodInfo);
    }*/

    @KafkaListener(
            topics = "Order_created",
            groupId = "inventory-group"
    )
    public void consume(orderDto event){
        if(get_byid(event.getItemId()).getAvailableUnits() >= event.getNumofItems()){
            paymentDetails temp = new paymentDetails(event.getOrdderId(), event.getUserId()
                                        ,event.getTotalPrice(), "USD");
            kafkaTemplate.send("inventory_created", temp);
            return;
        }
        kafkaTemplate.send("inventory_failed", null);

    }

}
