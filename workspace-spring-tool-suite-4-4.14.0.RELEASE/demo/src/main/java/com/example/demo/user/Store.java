package com.example.demo.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stores")

public class Store {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "store_name")
    private String storeName;
    
    @Column(name = "store_initial_revenue")
    private int initialRevenue;
    
    @Column(name = "store_current_revenue")
    private int currentRevenue;

//    private TreeMap<String, Item> itemTreeMap = new TreeMap<String, Item>();
//    private TreeMap<String, Drone> droneTreeMap = new TreeMap<String, Drone>();
//    private TreeMap<String, Order> orderTreeMap = new TreeMap<String, Order>();

    // Constructor
    public Store() {
    }
    
    public Store(String storeName,
                 int initialRevenue) {
        this.storeName = storeName;
        this.initialRevenue = initialRevenue;
        this.currentRevenue = initialRevenue;

    }

    public String getStoreName() {
        return storeName;
    }

    public int getInitialRevenue() {
        return initialRevenue;
    }

    public int getCurrentRevenue() {
        return currentRevenue;
    }
    
    public void setStoreName(String storeName) {
    	this.storeName = storeName;
    }
    
    public void setStoreInitialRevenue(int i) {
    	this.initialRevenue = i;
    }
    
    public void setStoreCurrentRevenue(int i) {
    	this.currentRevenue = i;
    }

//    public TreeMap<String, Item> getItemTreeMap() {
//        return itemTreeMap;
//    }

//    public TreeMap<String, Drone> getDroneTreeMap() {
//        return droneTreeMap;
//    }
//
//    public TreeMap<String, Order> getOrderTreeMap() {
//        return orderTreeMap;
//    }
//
//    // Add new item
//    public void addItems(Item newItem){
//        itemTreeMap.putIfAbsent(newItem.getProductName(), newItem);
//    }
//
//    // Display all the items in the store
//    public void displayItemMap() {
//        for (Map.Entry<String, Item> entry : itemTreeMap.entrySet()) {
//            System.out.println(entry.getKey() + "," + entry.getValue().getUnitWeight());
//        }
//    }
//
//    // Add new drone
//    public TreeMap<String, Drone> addDrones(Drone newDrone) {
//        droneTreeMap.putIfAbsent(newDrone.getDroneId(), newDrone);
//        return droneTreeMap;
//    }
//    // display all the drone
//    public void displayDroneMap(){
//        for (Map.Entry<String, Drone> entry : droneTreeMap.entrySet()) {
//            Drone drone = entry.getValue();
//            String flownBy = drone.getFlownBy();
//            if (flownBy.isEmpty()) {
//                System.out.println("droneID:" + drone.getDroneId() + ","
//                        + "total_cap:" + drone.getTotCap() + ","
//                        + "num_orders:" + drone.getNumOrders() + ","
//                        + "remaining_cap:" + drone.getRemainingCap() + ","
//                        + "trips_left:" + drone.getTripsLeft());
//            } else {
//                System.out.println("droneID:" + drone.getDroneId() + ","
//                        + "total_cap:" + drone.getTotCap() + ","
//                        + "num_orders:" + drone.getNumOrders() + ","
//                        + "remaining_cap:" + drone.getRemainingCap() + ","
//                        + "trips_left:" + drone.getTripsLeft() + ","
//                        + "flown_by:" + drone.getFlownBy());
//            }
//        }
//    }
//
//    // Add new order
//    public void addOrders(Order newOrder) {
//        orderTreeMap.putIfAbsent(newOrder.getOrderId(), newOrder);
//    }
//    // Display all the order purchased in this store
//    public void displayOrderMap(){
//        for (Map.Entry<String, Order> entry : orderTreeMap.entrySet()) {
//            Order order = entry.getValue();
//            System.out.println("orderID:" + order.getOrderId());
//            order.displayOrderLines();
//        }
//    }
//
//    // Remove an order
//    public TreeMap<String, Order> removeOrders(Order orderToRemove){
//        orderTreeMap.remove(orderToRemove.getOrderId());
//        return orderTreeMap;
//    }
//
//    // Add incoming revenue to the store
//    public void updateRevenue(int incomingRevenue){
//        this.currentRevenue = this.currentRevenue + incomingRevenue;
//    }
}
