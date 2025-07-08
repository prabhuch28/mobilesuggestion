package com.example.phonesuggester.service;

import com.example.phonesuggester.dto.PhoneRequest;
import com.example.phonesuggester.dto.PhoneResponse;
import com.example.phonesuggester.model.Phone;
import com.example.phonesuggester.repository.PhoneRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Phone Service Tests")
class PhoneServiceTest {

    @Mock
    private PhoneRepository phoneRepository;

    @InjectMocks
    private PhoneService phoneService;

    private Phone testPhone;
    private PhoneRequest testPhoneRequest;

    @BeforeEach
    void setUp() {
        testPhone = new Phone();
        testPhone.setId("1");
        testPhone.setName("iPhone 15 Pro");
        testPhone.setBrand("Apple");
        testPhone.setDescription("Latest iPhone with advanced features");
        testPhone.setPrice(999.99);
        testPhone.setCurrency("USD");
        testPhone.setUsageTypes(Arrays.asList("Flagship", "Camera"));
        testPhone.setImageUrl("https://example.com/iphone15.jpg");
        testPhone.setReleaseDate(LocalDateTime.now());
        testPhone.setStorageGB(256);
        testPhone.setRamGB(8);
        testPhone.setBatteryCapacity(4000);
        testPhone.setScreenSize(6.1);
        testPhone.setCameraCount(3);
        testPhone.setIs5G(true);
        testPhone.setIsWaterResistant(true);
        testPhone.setHasWirelessCharging(true);
        testPhone.setRating(4.8);
        testPhone.setReviewCount(150);
        testPhone.setCreatedAt(LocalDateTime.now());
        testPhone.setUpdatedAt(LocalDateTime.now());

        testPhoneRequest = new PhoneRequest();
        testPhoneRequest.setName("iPhone 15 Pro");
        testPhoneRequest.setBrand("Apple");
        testPhoneRequest.setDescription("Latest iPhone with advanced features");
        testPhoneRequest.setPrice(999.99);
        testPhoneRequest.setCurrency("USD");
        testPhoneRequest.setUsageTypes(Arrays.asList("Flagship", "Camera"));
        testPhoneRequest.setImageUrl("https://example.com/iphone15.jpg");
        testPhoneRequest.setReleaseDate(LocalDateTime.now());
        testPhoneRequest.setStorageGB(256);
        testPhoneRequest.setRamGB(8);
        testPhoneRequest.setBatteryCapacity(4000);
        testPhoneRequest.setScreenSize(6.1);
        testPhoneRequest.setCameraCount(3);
        testPhoneRequest.setIs5G(true);
        testPhoneRequest.setIsWaterResistant(true);
        testPhoneRequest.setHasWirelessCharging(true);
        testPhoneRequest.setRating(4.8);
    }

    @Test
    @DisplayName("Should find phone by ID successfully")
    void shouldFindPhoneById() {
        // Given
        String phoneId = "1";
        when(phoneRepository.findById(phoneId)).thenReturn(Optional.of(testPhone));

        // When
        Optional<PhoneResponse> result = phoneService.findById(phoneId);

        // Then
        assertThat(result).isPresent();
        assertThat(result.get().getId()).isEqualTo(phoneId);
        assertThat(result.get().getName()).isEqualTo("iPhone 15 Pro");
        verify(phoneRepository).findById(phoneId);
    }

    @Test
    @DisplayName("Should return empty when phone not found by ID")
    void shouldReturnEmptyWhenPhoneNotFoundById() {
        // Given
        String phoneId = "999";
        when(phoneRepository.findById(phoneId)).thenReturn(Optional.empty());

        // When
        Optional<PhoneResponse> result = phoneService.findById(phoneId);

        // Then
        assertThat(result).isEmpty();
        verify(phoneRepository).findById(phoneId);
    }

    @Test
    @DisplayName("Should find all phones successfully")
    void shouldFindAllPhones() {
        // Given
        List<Phone> phones = Arrays.asList(testPhone);
        when(phoneRepository.findAll()).thenReturn(phones);

        // When
        List<PhoneResponse> result = phoneService.findAll();

        // Then
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getName()).isEqualTo("iPhone 15 Pro");
        verify(phoneRepository).findAll();
    }

    @Test
    @DisplayName("Should find phones by brand successfully")
    void shouldFindPhonesByBrand() {
        // Given
        String brand = "Apple";
        List<Phone> phones = Arrays.asList(testPhone);
        when(phoneRepository.findByBrandIgnoreCase(brand)).thenReturn(phones);

        // When
        List<PhoneResponse> result = phoneService.findByBrand(brand);

        // Then
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getBrand()).isEqualTo(brand);
        verify(phoneRepository).findByBrandIgnoreCase(brand);
    }

    @Test
    @DisplayName("Should find phones by usage type successfully")
    void shouldFindPhonesByUsageType() {
        // Given
        String usageType = "Flagship";
        List<Phone> phones = Arrays.asList(testPhone);
        when(phoneRepository.findByUsageTypesContainingIgnoreCase(usageType)).thenReturn(phones);

        // When
        List<PhoneResponse> result = phoneService.findByUsageType(usageType);

        // Then
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getUsageTypes()).contains(usageType);
        verify(phoneRepository).findByUsageTypesContainingIgnoreCase(usageType);
    }

    @Test
    @DisplayName("Should find phones by price range successfully")
    void shouldFindPhonesByPriceRange() {
        // Given
        Double minPrice = 500.0;
        Double maxPrice = 1000.0;
        List<Phone> phones = Arrays.asList(testPhone);
        when(phoneRepository.findByPriceBetween(minPrice, maxPrice)).thenReturn(phones);

        // When
        List<PhoneResponse> result = phoneService.findByPriceRange(minPrice, maxPrice);

        // Then
        assertThat(result).hasSize(1);
        assertThat(result.get(0).getPrice()).isBetween(minPrice, maxPrice);
        verify(phoneRepository).findByPriceBetween(minPrice, maxPrice);
    }

    @Test
    @DisplayName("Should search phones successfully")
    void shouldSearchPhones() {
        // Given
        String query = "iPhone";
        List<Phone> phones = Arrays.asList(testPhone);
        when(phoneRepository.findByNameContainingIgnoreCaseOrBrandContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
                query, query, query)).thenReturn(phones);

        // When
        List<PhoneResponse> result = phoneService.searchPhones(query);

        // Then
        assertThat(result).hasSize(1);
        verify(phoneRepository).findByNameContainingIgnoreCaseOrBrandContainingIgnoreCaseOrDescriptionContainingIgnoreCase(
                query, query, query);
    }

    @Test
    @DisplayName("Should create phone successfully")
    void shouldCreatePhone() {
        // Given
        when(phoneRepository.save(any(Phone.class))).thenReturn(testPhone);

        // When
        PhoneResponse result = phoneService.createPhone(testPhoneRequest);

        // Then
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(testPhoneRequest.getName());
        assertThat(result.getBrand()).isEqualTo(testPhoneRequest.getBrand());
        verify(phoneRepository).save(any(Phone.class));
    }

    @Test
    @DisplayName("Should update phone successfully")
    void shouldUpdatePhone() {
        // Given
        String phoneId = "1";
        when(phoneRepository.findById(phoneId)).thenReturn(Optional.of(testPhone));
        when(phoneRepository.save(any(Phone.class))).thenReturn(testPhone);

        // When
        Optional<PhoneResponse> result = phoneService.updatePhone(phoneId, testPhoneRequest);

        // Then
        assertThat(result).isPresent();
        assertThat(result.get().getName()).isEqualTo(testPhoneRequest.getName());
        verify(phoneRepository).findById(phoneId);
        verify(phoneRepository).save(any(Phone.class));
    }

    @Test
    @DisplayName("Should return empty when updating non-existent phone")
    void shouldReturnEmptyWhenUpdatingNonExistentPhone() {
        // Given
        String phoneId = "999";
        when(phoneRepository.findById(phoneId)).thenReturn(Optional.empty());

        // When
        Optional<PhoneResponse> result = phoneService.updatePhone(phoneId, testPhoneRequest);

        // Then
        assertThat(result).isEmpty();
        verify(phoneRepository).findById(phoneId);
        verify(phoneRepository, never()).save(any(Phone.class));
    }

    @Test
    @DisplayName("Should delete phone successfully")
    void shouldDeletePhone() {
        // Given
        String phoneId = "1";
        when(phoneRepository.existsById(phoneId)).thenReturn(true);

        // When
        boolean result = phoneService.deletePhone(phoneId);

        // Then
        assertThat(result).isTrue();
        verify(phoneRepository).existsById(phoneId);
        verify(phoneRepository).deleteById(phoneId);
    }

    @Test
    @DisplayName("Should return false when deleting non-existent phone")
    void shouldReturnFalseWhenDeletingNonExistentPhone() {
        // Given
        String phoneId = "999";
        when(phoneRepository.existsById(phoneId)).thenReturn(false);

        // When
        boolean result = phoneService.deletePhone(phoneId);

        // Then
        assertThat(result).isFalse();
        verify(phoneRepository).existsById(phoneId);
        verify(phoneRepository, never()).deleteById(phoneId);
    }
} 