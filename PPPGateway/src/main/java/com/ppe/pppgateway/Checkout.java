package com.ppe.pppgateway;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ppe.pppgateway.indivisual_payments_classes.API_KEY_C;

public class Checkout {
    private Context context;
    private Float amount;
    private String vendor_country;
    private String buyer_country;
    private String API_KEY ;
    private String vendor_name;
    public Checkout(){};
    public Checkout(Context mContext, Float amount, String vendor_country, String buyer_country, String API_KEY,String vendor_name){
        this.context =mContext;
        this.amount = amount;this.amount = amount;
        this.vendor_country = vendor_country;
        this.buyer_country = buyer_country;
        this.API_KEY = API_KEY;
        this.vendor_name = vendor_name;
        API_KEY_C.API_KEY = API_KEY;
        API_KEY_C.set_APIKEY(API_KEY);

    }
    public void setAPI_KEY(String API_KEY) {
        this.API_KEY = API_KEY;
        API_KEY_C.API_KEY = API_KEY;
        API_KEY_C.set_APIKEY(API_KEY);
    }
    // get payout amount;
    public Float getPPPAdjustedAmount(){
        Float payoutAmount =(( ParityData.hashMap.get(buyer_country) / ParityData.hashMap.get(vendor_country)) * amount) ;
        Toast.makeText(context, ""+payoutAmount, Toast.LENGTH_LONG).show();
        API_KEY_C.PPP_Adjusted_Amount = payoutAmount;
        API_KEY_C.setPPP_Adjusted_Amount(payoutAmount);
        return payoutAmount;
    }
    public void updateDB(){

    }

    // open payment modes
    public void openPaymentModes(){
        validAPIKey();
        Intent i = new Intent(context, PaymentModes.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("vendor_name",vendor_name);
        i.putExtra("API_KEY",API_KEY);
        i.putExtra("buyer_country",buyer_country);
        i.putExtra("vendor_country",vendor_country);
        i.putExtra("amount",amount);

        context.startActivity(i);
    }
    // authenticating API key
    public void validAPIKey(){
        DatabaseReference root_ref = FirebaseDatabase.getInstance().getReference();
        DatabaseReference API_KEY_ref = root_ref.child("API_KEY");

        API_KEY_ref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                boolean flag = false;
                for(DataSnapshot data: snapshot.getChildren()){
                    if (data.child(API_KEY_C.API_KEY).exists()) {
                        Toast.makeText(context, "valid api key", Toast.LENGTH_SHORT).show();
                        flag = true;
                    } else {
                        //do something if not exists
                    }
                }
                if(!flag)
                    Toast.makeText(context, "valid API key", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
