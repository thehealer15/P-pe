package com.ppe.gateway;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ppe.pppgateway.Checkout;

public class MainActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.cards_payment_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//(Context mContext, Float amount, String vendor_country, String buyer_country, String API_KEY,String vendor_name){
                Checkout obj = new Checkout(getApplicationContext() ,1F, "USD" ,"IND" ,"API_KEY","Gavali Associates");
               try{
                   obj.openPaymentModes();
               }catch (Exception e){
                   Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                   Log.d("tag",e.getMessage());
               }
            }
        });
    }
}