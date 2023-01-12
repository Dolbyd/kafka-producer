package com.producer.kafkaproducer.controller;

import com.producer.kafkaproducer.beans.Person;
import com.producer.kafkaproducer.producer.KafkaProducerImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/bankHapoalim")
@RequiredArgsConstructor
public class PersonController {

    @Autowired
    private KafkaProducerImpl messageProducer;

    @PostMapping("/person")
    public String getCustomerCouponByCategory(@RequestBody Person person) {
        if (!messageProducer.sendMessage(person.toString())) {
            return "success";
        }
        return "failure";
    }
}
