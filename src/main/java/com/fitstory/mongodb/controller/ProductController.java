package com.fitstory.mongodb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fitstory.mongodb.Exceptions.ItemsNotFoundException;
import com.fitstory.mongodb.core.Register;
import com.fitstory.mongodb.entity.Items;
import com.fitstory.mongodb.repository.ItemsRepository;

@RestController
public class ProductController {
	@Autowired
	ItemsRepository itemsRepository;
	
	/*
	void addItem(String item,Double price) throws CheckoutInProgressException{
		
	}  */
	

	@PostMapping("/additems")
	public ResponseEntity<Items> addItems(@RequestBody Items items) {
		try {
			Items _items = itemsRepository.save(items);
			return new ResponseEntity<>(_items, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getitems")
	public ResponseEntity<List<Items>> getItems() {
		try {
			List<Items>  listItems=new ArrayList<>();
			//Register register=null;
			//register=Register.getInstance();
			//listItems=register.getAllItems();
			listItems=getAllItems();
			System.out.println("###"+listItems);
			return new ResponseEntity<>(listItems, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
		 private List<Items> getAllItems() {
		    	System.out.println("ENtered into Registered class and get AllItems");
		    	List<Items> itemsList=null;
		    	itemsList=itemsRepository.findAll();
		    	System.out.println("###Items="+itemsList);
		    	  	return itemsList;
		    	
		    }
	
}
