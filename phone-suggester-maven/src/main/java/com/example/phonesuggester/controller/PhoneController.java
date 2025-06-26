package com.example.phonesuggester.controller;

import com.example.phonesuggester.service.AmazonService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/phones")
public class PhoneController {

    @Autowired
    private AmazonService amazonService;

    // ✅ 1. Get all phones from DummyJSON (with optional limit)
    @GetMapping("/external")
    public ResponseEntity<String> getPhonesFromDummyJson(@RequestParam(defaultValue = "100") int limit) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            String url = "https://dummyjson.com/products/search?q=phone&limit=" + limit;
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return ResponseEntity.ok(response.body());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to fetch phones. Error: " + e.getMessage());
        }
    }

    // ✅ 2. Filter phones from DummyJSON by query param `type`
    @GetMapping("/external/filter")
    public ResponseEntity<String> getPhonesByType(
            @RequestParam String type,
            @RequestParam(defaultValue = "100") int limit
    ) {
        ResponseEntity<String> allPhones = getPhonesFromDummyJson(limit);
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(allPhones.getBody());
            ArrayNode results = mapper.createArrayNode();

            for (JsonNode p : root.get("products")) {
                String combinedText = p.get("title").asText("") + " " + p.get("description").asText("");
                if (combinedText.toLowerCase().contains(type.toLowerCase())) {
                    results.add(p);
                }
            }

            ObjectNode output = mapper.createObjectNode();
            output.set("products", results);
            output.put("total", results.size());

            return ResponseEntity.ok(output.toString());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error filtering phones: " + e.getMessage());
        }
    }

    // ✅ 3. Amazon Mock Suggestion API
    @GetMapping("/amazon")
    public ResponseEntity<?> getAmazonPhones(@RequestParam String type) {
        try {
            List<Map<String, String>> phones = amazonService.searchPhones(type);
            return ResponseEntity.ok(phones);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("error", "Amazon API failed", "details", e.getMessage()));
        }
    }

    // ✅ 4. Get all phones from DummyJSON (direct raw access)
    @GetMapping("/live")
    public ResponseEntity<String> getAllPhonesDirect() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://dummyjson.com/products/search?q=phone"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return ResponseEntity.ok(response.body());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error fetching phone list: " + e.getMessage());
        }
    }

    // ✅ 5. Filter phones by type using DummyJSON and path variable
    @GetMapping("/live/type/{type}")
    public ResponseEntity<String> getPhonesByCategory(@PathVariable String type) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://dummyjson.com/products/search?q=phone"))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(response.body());
            ArrayNode filtered = mapper.createArrayNode();

            for (JsonNode product : root.get("products")) {
                String text = product.get("title").asText() + " " + product.get("description").asText();
                if (text.toLowerCase().contains(type.toLowerCase())) {
                    filtered.add(product);
                }
            }

            ObjectNode result = mapper.createObjectNode();
            result.set("products", filtered);
            result.put("total", filtered.size());

            return ResponseEntity.ok(result.toString());

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error filtering phones by type: " + e.getMessage());
        }
    }
}