package com.example.sborders.listeners;

import org.springframework.batch.core.ItemReadListener;
import org.springframework.stereotype.Component;
import com.example.sborders.entity.Orders;

@Component
public class OrderReaderListener implements ItemReadListener<Orders> {

    @Override
    public void beforeRead() {
        // Called before reading each item
        System.out.println("Preparing to read Order item...");
    }

    @Override
    public void afterRead(Orders item) {
        // Called after reading each item
        System.out.println("Successfully read Order item: " + item);
    }

    @Override
    public void onReadError(Exception ex) {
        // Called when there is an error while reading an item
        System.err.println("Error reading Order item: " + ex.getMessage());
    }
}