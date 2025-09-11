package com.example.sborders.config;


import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.sborders.entity.Orders;

@Component
public class OrderProcessor implements ItemProcessor<Orders, Orders> {

    @Override
    public Orders process(Orders order) throws Exception {
        // Example transformation: rounding sales to nearest integer
        order.setSales(Math.round(order.getSales()));
        return order;
    }
}
