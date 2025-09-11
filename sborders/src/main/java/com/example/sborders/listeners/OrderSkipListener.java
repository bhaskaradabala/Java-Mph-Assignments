package com.example.sborders.listeners;

import org.springframework.batch.core.SkipListener;
import org.springframework.stereotype.Component;

import com.example.sborders.entity.Orders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class OrderSkipListener implements SkipListener<Orders, Orders> {

    private static final Logger logger = LoggerFactory.getLogger(OrderSkipListener.class);

    @Override
    public void onSkipInRead(Throwable t) {
        // Called when an item is skipped during the reading phase
        logger.error("Error reading Order item", t);
    }

    @Override
    public void onSkipInProcess(Orders item, Throwable t) {
        // Called when an item is skipped during the processing phase
        logger.error("Error processing Order item: " + item, t);
    }

    @Override
    public void onSkipInWrite(Orders item, Throwable t) {
        // Called when an item is skipped during the writing phase
        logger.error("Error writing Order item: " + item, t);
    }
}