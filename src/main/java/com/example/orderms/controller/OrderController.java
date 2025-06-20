package com.example.orderms.controller;

import com.example.orderms.controller.dto.ApiResponse;
import com.example.orderms.controller.dto.OrderResponse;
import com.example.orderms.controller.dto.PaginationResponse;
import com.example.orderms.service.OrderService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class OrderController {
    private final OrderService orderService;


    public OrderController(OrderService orderService) {
        this.orderService = orderService;

    }
    @GetMapping("/customesrs{customesrsId}/orders")

    public ResponseEntity<ApiResponse<OrderResponse>>listOrders(@PathVariable("CustomerId") Long customeId,
                                                                @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize){

        var pageResponse = orderService.findAllByCustomerId(customeId, PageRequest.of(page, pageSize));

        return ResponseEntity.ok(new ApiResponse<>(
                pageResponse.getContent(),
                PaginationResponse.fromPage(pageResponse)

        ));

    }
}
