package com.example.orderCreationService.service;

import com.example.orderCreationService.entity.itemDto;
import com.example.orderCreationService.entity.orderInfo;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.example.orderCreationService.repository.inventoryRepo;

import java.util.List;

@Service
public class orderService {

    private inventoryClient client;
    private inventoryRepo repo;
    private NewTopic topic;
    private KafkaTemplate<String, orderInfo> kafkaTemplate;
    //private KafkaTemplate<String, String> kafkaTemplate;

    public orderService(inventoryClient client, inventoryRepo repo, NewTopic topic, KafkaTemplate<String, orderInfo> kafkaTemplate) {
        this.client = client;
        this.repo = repo;
        this.topic = topic;
        this.kafkaTemplate = kafkaTemplate;
    }

    public List<itemDto> get_all() {
        return client.get_all();
    }

    public itemDto get_byid(int prodId) {
        return client.get_byid(prodId);
    }

    public itemDto post_prod(itemDto prod) {
        return client.post_prod(prod);
    }

    public List<itemDto> delete_byid(int prodId) {
        return client.delete_byid(prodId);
    }

    public List<itemDto> put_byid(itemDto prod) {
        return client.put_byid(prod);
    }

    public void create_order(orderInfo orderData) {
        repo.save(orderData);
        /*kafkaTemplate.send(
                "Order-created",
                orderData.toString()
        );*/
        kafkaTemplate.send("Order_created", orderData);
    }

    /*public List<itemDto> search(String prodInfo) {
        return client.search(prodInfo);
    }*/
}
