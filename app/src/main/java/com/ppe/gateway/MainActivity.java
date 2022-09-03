package com.ppe.gateway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ppe.pppgateway.Checkout;
import com.ppe.pppgateway.ParityData;
import com.ppe.pppgateway.indivisual_payments_classes.API_KEY_C;

import java.util.HashMap;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btn;

    EditText ET_amount, src_country, target_country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HashMap<String, Float> hashMap = new HashMap<>();
        hashMap.put("AUS", 1.438979F);
        hashMap.put("AUT", 0.770831F);
        hashMap.put("BEL", 0.742723F);
        hashMap.put("CAN", 1.253066F);
        hashMap.put("CZE", 12.919712F);
        hashMap.put("DNK", 6.593618F);
        hashMap.put("FIN", 0.829754F);
        hashMap.put("FRA", 0.725323F);
        hashMap.put("DEU", 0.741488F);
        hashMap.put("GRC", 0.547807F);
        hashMap.put("HUN", 154.840118F);
        hashMap.put("ISL", 150.642103F);
        hashMap.put("IRL", 0.787487F);
        hashMap.put("ITA", 0.654354F);
        hashMap.put("JPN", 100.41164F);
        hashMap.put("KOR", 847.456839F);
        hashMap.put("LUX", 0.851323F);
        hashMap.put("MEX", 10.043314F);
        hashMap.put("NLD", 0.769839F);
        hashMap.put("NZL", 1.486354F);
        hashMap.put("NOR", 9.674744F);
        hashMap.put("POL", 1.837204F);
        hashMap.put("PRT", 0.571596F);
        hashMap.put("SVK", 0.540124F);
        hashMap.put("ESP", 0.624463F);
        hashMap.put("SWE", 8.708853F);
        hashMap.put("CHE", 1.104516F);
        hashMap.put("TUR", 2.781851F);
        hashMap.put("GBR", 0.692802F);
        hashMap.put("USA", 1F);
        hashMap.put("BRA", 2.526131F);
        hashMap.put("CHL", 430.349555F);
        hashMap.put("CHN", 4.187342F);
        hashMap.put("COL", 1358.650605F);
        hashMap.put("EST", 0.546689F);
        hashMap.put("IND", 23.138138F);
        hashMap.put("IDN", 4758.700957F);
        hashMap.put("ISR", 3.799707F);
        hashMap.put("RUS", 27.331899F);
        hashMap.put("SVN", 0.565944F);
        hashMap.put("ZAF", 7.168097F);
        hashMap.put("LVA", 0.50634F);
        hashMap.put("LTU", 0.464377F);
        hashMap.put("SAU", 1.784958F);
        hashMap.put("EA19", 0.703807F);
        hashMap.put("ARG", 43.135409F);
        hashMap.put("CRI", 332.026908F);
        hashMap.put("BGR", 0.720483F);
        hashMap.put("HRV", 3.273844F);
        hashMap.put("CYP", 0.611901F);
        hashMap.put("MLT", 0.589318F);
        hashMap.put("ROU", 1.745966F);
        hashMap.put("MKD", 19.545723F);
        hashMap.put("ZMB", 6.190462F);
        hashMap.put("HKG", 5.851252F);
        hashMap.put("MDG", 1205.855631F);
        hashMap.put("MAR", 3.859583F);
        hashMap.put("SGP", 0.839572F);
        hashMap.put("EU27_2020", 0.667415F);
        hashMap.put("ALB", 42.969328F);
        hashMap.put("GEO", 0.955514F);
        hashMap.put("CMR", 226.712348F);
        hashMap.put("SEN", 236.380142F);



        ET_amount = findViewById(R.id.amount_tv);
        src_country = findViewById(R.id.src_country);
        target_country = findViewById(R.id.target_country);

        btn = findViewById(R.id.cards_payment_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//(Context mContext, Float amount, String vendor_country, String buyer_country, String API_KEY,String vendor_name){
                // get amount here only

                try{
                    Float amount = Float.parseFloat(ET_amount.getText().toString().trim());
                    String src = src_country.getText().toString().trim().toUpperCase(), tar = target_country.getText().toString().trim().toUpperCase();

                    Float payoutAmount =(( hashMap.get(tar) / hashMap.get(src)) * amount) ;

//                    Toast.makeText(MainActivity.this, payoutAmount.toString(), Toast.LENGTH_SHORT).show();
                    API_KEY_C.setPPP_Adjusted_Amount(payoutAmount);

                    Checkout obj = new Checkout(getApplicationContext() ,amount, src ,tar ,"2oiMDOgSyDNLyUtYyZdP9MLpEC72","Gavali Associates");
                    obj.openPaymentModes();
               }catch (Exception e){
                   Toast.makeText(MainActivity.this, "goli" + e.getMessage() , Toast.LENGTH_SHORT).show();
                   Log.d("tag",e.getMessage());
               }
            }
        });
    }
    /*
    public void init(){
        hashMap.put("AUS", 1.438979F);
        hashMap.put("AUT", 0.770831F);
        hashMap.put("BEL", 0.742723F);
        hashMap.put("CAN", 1.253066F);
        hashMap.put("CZE", 12.919712F);
        hashMap.put("DNK", 6.593618F);
        hashMap.put("FIN", 0.829754F);
        hashMap.put("FRA", 0.725323F);
        hashMap.put("DEU", 0.741488F);
        hashMap.put("GRC", 0.547807F);
        hashMap.put("HUN", 154.840118F);
        hashMap.put("ISL", 150.642103F);
        hashMap.put("IRL", 0.787487F);
        hashMap.put("ITA", 0.654354F);
        hashMap.put("JPN", 100.41164F);
        hashMap.put("KOR", 847.456839F);
        hashMap.put("LUX", 0.851323F);
        hashMap.put("MEX", 10.043314F);
        hashMap.put("NLD", 0.769839F);
        hashMap.put("NZL", 1.486354F);
        hashMap.put("NOR", 9.674744F);
        hashMap.put("POL", 1.837204F);
        hashMap.put("PRT", 0.571596F);
        hashMap.put("SVK", 0.540124F);
        hashMap.put("ESP", 0.624463F);
        hashMap.put("SWE", 8.708853F);
        hashMap.put("CHE", 1.104516F);
        hashMap.put("TUR", 2.781851F);
        hashMap.put("GBR", 0.692802F);
        hashMap.put("USA", 1F);
        hashMap.put("BRA", 2.526131F);
        hashMap.put("CHL", 430.349555F);
        hashMap.put("CHN", 4.187342F);
        hashMap.put("COL", 1358.650605F);
        hashMap.put("EST", 0.546689F);
        hashMap.put("IND", 23.138138F);
        hashMap.put("IDN", 4758.700957F);
        hashMap.put("ISR", 3.799707F);
        hashMap.put("RUS", 27.331899F);
        hashMap.put("SVN", 0.565944F);
        hashMap.put("ZAF", 7.168097F);
        hashMap.put("LVA", 0.50634F);
        hashMap.put("LTU", 0.464377F);
        hashMap.put("SAU", 1.784958F);
        hashMap.put("EA19", 0.703807F);
        hashMap.put("ARG", 43.135409F);
        hashMap.put("CRI", 332.026908F);
        hashMap.put("BGR", 0.720483F);
        hashMap.put("HRV", 3.273844F);
        hashMap.put("CYP", 0.611901F);
        hashMap.put("MLT", 0.589318F);
        hashMap.put("ROU", 1.745966F);
        hashMap.put("MKD", 19.545723F);
        hashMap.put("ZMB", 6.190462F);
        hashMap.put("HKG", 5.851252F);
        hashMap.put("MDG", 1205.855631F);
        hashMap.put("MAR", 3.859583F);
        hashMap.put("SGP", 0.839572F);
        hashMap.put("EU27_2020", 0.667415F);
        hashMap.put("ALB", 42.969328F);
        hashMap.put("GEO", 0.955514F);
        hashMap.put("CMR", 226.712348F);
        hashMap.put("SEN", 236.380142F);

    }*/
}