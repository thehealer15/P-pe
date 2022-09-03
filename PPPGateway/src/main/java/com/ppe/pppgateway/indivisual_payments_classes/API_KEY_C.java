package com.ppe.pppgateway.indivisual_payments_classes;

public class API_KEY_C {
    public static String API_KEY;
    public static int ID = 5;
    public static Float PPP_Adjusted_Amount=1F;

    public static Float getPPP_Adjusted_Amount(){
        return  PPP_Adjusted_Amount;
    }
    public static void setPPP_Adjusted_Amount(Float x){
        PPP_Adjusted_Amount = Float.valueOf(Math.round(x));
    }

    public static void set_APIKEY(String KEY){
        API_KEY = KEY;
    }
    public static int getID(){
        return ID++;
    }
}
