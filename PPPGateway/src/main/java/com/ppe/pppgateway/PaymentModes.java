package com.ppe.pppgateway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ppe.pppgateway.indivisual_payments_classes.API_KEY_C;
import com.ppe.pppgateway.indivisual_payments_classes.CardBottomSheet;
import com.ppe.pppgateway.indivisual_payments_classes.E_WalletsBottomSheet;
import com.ppe.pppgateway.indivisual_payments_classes.NetBankingBottomSheet;
import com.ppe.pppgateway.indivisual_payments_classes.UPI_bottom_sheet;

import java.util.HashMap;

public class PaymentModes extends AppCompatActivity {
    Context context;
    Float amount;
    String vendor_country;
    String buyer_country;
    String API_KEY;
    String vendor_name;
    Float PPP_AdjustedAmount;
    TextView business_name, PPPAdjusted_amountTV;
    Button card_payment_btn , upi_payment_btn , net_banking_btn, e_wallet_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.payment_modes);
        init();
        Intent i = getIntent();

        amount = i.getFloatExtra("amount",-1);
//        amount = getPPPAdjustedAmount();
        vendor_country = i.getStringExtra("vendor_country");
        buyer_country = i.getStringExtra("buyer_country");
        API_KEY = i.getStringExtra("API_KEY");
        vendor_name = i.getStringExtra("vendor_name");
        PPP_AdjustedAmount = i.getFloatExtra("getPPPAdjustedAmount",-5F);
//        PPPAdjusted_amountTV.setText(""+PPP_AdjustedAmount);
        business_name.setText(vendor_name);
    }
    public void init(){
        business_name = findViewById(R.id.business_name);
        PPPAdjusted_amountTV = findViewById(R.id.ppp_adjusted_amountTV);
        card_payment_btn = findViewById(R.id.cards_payment_btn);
        upi_payment_btn = findViewById(R.id.UPI);
        net_banking_btn = findViewById(R.id.net_banking);
        e_wallet_btn = findViewById(R.id.wallets);

        PPPAdjusted_amountTV.setText(API_KEY_C.getPPP_Adjusted_Amount().toString());

    card_payment_btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
//            so bottom sheet will be here
            CardBottomSheet sheet = new CardBottomSheet();
            sheet.show(getSupportFragmentManager() , "CardBottomSheet");
        }
    });

        upi_payment_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    UPI_bottom_sheet sheet = new UPI_bottom_sheet();
                    sheet.show(getSupportFragmentManager() , "upi");
                }catch (Exception e){
                    Log.d("upi_onclick",e.getMessage());
                }
            }
        });
        net_banking_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NetBankingBottomSheet sheet = new NetBankingBottomSheet();
                sheet.show(getSupportFragmentManager(), "netBankingBottomSheet");
            }
        });
        e_wallet_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                E_WalletsBottomSheet sheet = new E_WalletsBottomSheet();
                sheet.show(getSupportFragmentManager(), "ewallets");
            }
        });
    }
    public void updateDB(){

    }
    public Float getPPPAdjustedAmount(){
        Float payoutAmount =( ParityData.hashMap.get(buyer_country) / ParityData.hashMap.get(vendor_country)) * amount;
        Toast.makeText(context, ""+payoutAmount, Toast.LENGTH_LONG).show();
        return payoutAmount;
    }

}