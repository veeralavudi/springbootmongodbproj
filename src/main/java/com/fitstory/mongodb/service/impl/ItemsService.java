package com.fitstory.mongodb.service.impl;

import java.util.Map;

import com.fitstory.mongodb.Exceptions.CheckoutInProgressException;
import com.fitstory.mongodb.Exceptions.InvalidItemScan;
import com.fitstory.mongodb.Exceptions.NoCheckoutInProgressException;
import com.fitstory.mongodb.core.Bill;

public interface ItemsService {
	
	public Map<String, Double> addItem(String item,Double price);
    double scanItem(String item) throws InvalidItemScan, NoCheckoutInProgressException;
    void startCheckout() throws CheckoutInProgressException;
    Bill finishCheckout() throws NoCheckoutInProgressException;
    void cancelCheckout() throws NoCheckoutInProgressException;
}
