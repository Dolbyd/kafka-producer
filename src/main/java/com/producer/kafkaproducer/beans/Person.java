package com.producer.kafkaproducer.beans;

import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class Person {

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String gander;

}
