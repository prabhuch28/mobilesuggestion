package com.example.phonesuggester.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AmazonService {

    @Value("${amazon.associate.tag}")
    private String associateTag;

    public List<Map<String, String>> searchPhones(String keyword) {
        List<Map<String, String>> phones = new ArrayList<>();

        Map<String, String> phone = new HashMap<>();
        phone.put("title", "Amazon Suggested - iQOO Z9");
        phone.put("image", "https://example.com/phone.jpg");
        phone.put("price", "₹15,999");
        phone.put("url", "https://www.amazon.in/dp/EXAMPLE123");

        phones.add(phone);
        return phones;
    }
}