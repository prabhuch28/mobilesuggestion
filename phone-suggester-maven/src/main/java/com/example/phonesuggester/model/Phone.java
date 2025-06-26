package com.example.phonesuggester.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "phones")
public class Phone {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private List<String> usageTypes;
    private String imageUrl;

    public Phone() {}

    public Phone(String name, String description, double price, List<String> usageTypes, String imageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.usageTypes = usageTypes;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters

    public String getId() { return id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }

    public List<String> getUsageTypes() { return usageTypes; }

    public void setUsageTypes(List<String> usageTypes) { this.usageTypes = usageTypes; }

    public String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
