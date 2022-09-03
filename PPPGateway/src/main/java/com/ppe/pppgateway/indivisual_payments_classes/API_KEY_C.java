package com.ppe.pppgateway.indivisual_payments_classes;

public class API_KEY_C {
    public static String API_KEY;
    public static int ID = 5;
    public static void set_APIKEY(String KEY){
        API_KEY = KEY;
    }
    public static int getID(){
        return ID++;
    }
}
