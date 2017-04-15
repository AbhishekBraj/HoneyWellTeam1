package com.honeywell.team1.HoneywellTeam1.config;

public class BasePath {

    public static String getInventory(){
        return "/store/inventory";
    }

    public static String postOrder(){
        return "/store/order";
    }

    public static String getOrderId(int orderId){
        return "store/order/"+orderId;
    }

    public static String deleteOrderId(int orderId){
        return "store/order/"+orderId;
    }
}