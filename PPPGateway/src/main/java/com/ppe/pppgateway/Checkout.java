package com.ppe.pppgateway;

import android.content.Context;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Checkout {
    private Context context;
    private Float amount;
    private String vendor_country;
    private String buyer_country;
    private String API_KEY;

    public Checkout(){};
    public Checkout(Context mContext, Float amount, String vendor_country, String buyer_country, String API_KEY){
        this.context =mContext;
        this.amount = amount;this.amount = amount;
        this.vendor_country = vendor_country;
        this.buyer_country = buyer_country;
        this.API_KEY = API_KEY;
    }

    public void setAPI_KEY(String API_KEY) {
        this.API_KEY = API_KEY;
    }

    // get payout amount;
    public Float getPPPAdjustedAmount(){
        Float payoutAmount =( ParityData.hashMap.get(buyer_country) / ParityData.hashMap.get(vendor_country)) * amount;
        Toast.makeText(context, ""+payoutAmount, Toast.LENGTH_LONG).show();
        return payoutAmount;
    }
    public void updateDB(){
        DatabaseReference db = FirebaseDatabase.getInstance().getReference();
        db.child("Goli").setValue("masti nai");
        /**
         * I can update information to database from here
         *
         * */
    }
}
