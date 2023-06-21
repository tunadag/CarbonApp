package com.tunadag.controller;

import com.tunadag.dto.request.BeerCreateRequestDto;
import com.tunadag.dto.request.WineCreateRequestDto;
import com.tunadag.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/createwine")
    public ResponseEntity<Boolean> createWine(WineCreateRequestDto dto) {
        return ResponseEntity.ok(productService.createWine(dto));
    }
    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping("/createbeer")
    public ResponseEntity<Boolean> createBeer(BeerCreateRequestDto dto) {
        return ResponseEntity.ok(productService.createBeer(dto));
    }
}
