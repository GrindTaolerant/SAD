package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StoreRepository;

import com.example.demo.user.Store;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class StoreController {
    @Autowired
    private StoreRepository storeRepository;

    //get all users
    @GetMapping("/stores")
    public List<Store> getAllStores(){
        return storeRepository.findAll();
    }
    
    
    // create store rest api
    @PostMapping("/stores")
    public Store createStore(@RequestBody Store store) {
    	return storeRepository.save(store);
    }
    
    
    // get store by id rest api
    @GetMapping("/stores/{id}")
    public ResponseEntity<Store> getStoreById(@PathVariable Long id) {
    	
    	Store store = storeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Store not exist with id :" + id));
    	
    	return  ResponseEntity.ok(store);
    }
    
    // update store rest api
    @PutMapping("/stores/{id}")
    public ResponseEntity<Store> updateStore(@PathVariable Long id, @RequestBody Store storeDetails){
    	
    	Store store = storeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Store not exist with id :" + id));
    	
    	store.setStoreName(storeDetails.getStoreName());
    	store.setStoreInitialRevenue(storeDetails.getInitialRevenue());
    	store.setStoreCurrentRevenue(storeDetails.getCurrentRevenue());
    	
    	Store updateStore = storeRepository.save(store);
    	
    	return ResponseEntity.ok(updateStore);
    	
    }
    
    // delete store rest api
    @DeleteMapping("/stores/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
    	Store store = storeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Store not exist with id :" + id));
    	
    	storeRepository.delete(store);
    	Map<String, Boolean> response = new HashMap<>();
    	response.put("deleted", Boolean.TRUE);
    	
    	return ResponseEntity.ok(response);
    }
    


}
