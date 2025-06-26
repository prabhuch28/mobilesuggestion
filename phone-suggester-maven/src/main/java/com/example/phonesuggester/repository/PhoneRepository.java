package com.example.phonesuggester.repository;

import com.example.phonesuggester.model.Phone;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhoneRepository extends MongoRepository<Phone, String> {
    List<Phone> findByPriceBetweenAndUsageTypesIn(double minPrice, double maxPrice, List<String> usageTypes);
    List<Phone> findByPriceBetween(double minPrice, double maxPrice);
    List<Phone> findByUsageTypesIn(List<String> usageTypes);
}
