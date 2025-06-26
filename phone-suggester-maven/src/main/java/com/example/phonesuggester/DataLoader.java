package com.example.phonesuggester;

import com.example.phonesuggester.model.Phone;
import com.example.phonesuggester.repository.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public void run(String... args) {
        System.out.println("🚀 DataLoader is running...");

        if (phoneRepository.count() == 0) {
            List<Phone> phones = generatePhones(); // Use the new method
            phoneRepository.saveAll(phones);
            System.out.println("✅ Inserted " + phones.size() + " phones.");
        } else {
            System.out.println("✔️ Data already present. Skipping insert.");
        }
    }

    private List<Phone> generatePhones() {
        List<Phone> phones = new ArrayList<>();

        phones.add(new Phone("iPhone 14", "A15 Bionic | iPhone 14", 79999, List.of("photography", "business"), "https://example.com/images/iphone14.jpg"));
        phones.add(new Phone("Samsung Galaxy S22", "Exynos 2200 | Galaxy S22", 74999, List.of("gaming", "media"), "https://example.com/images/galaxy_s22.jpg"));
        phones.add(new Phone("OnePlus 10 Pro", "Snapdragon 8 Gen 1 | OnePlus 10 Pro", 66999, List.of("gaming", "general"), "https://example.com/images/oneplus10pro.jpg"));
        phones.add(new Phone("Google Pixel 6", "Google Tensor | Pixel 6", 59999, List.of("photography", "casual"), "https://example.com/images/pixel6.jpg"));
        phones.add(new Phone("Xiaomi Redmi Note 11", "Snapdragon 680 | Redmi Note 11", 13999, List.of("budget", "casual"), "https://example.com/images/redmi_note_11.jpg"));
        // Add more phones as needed...

        return phones;
    }
}
