package com.ppe.gateway;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ppe.pppgateway.Checkout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseReference dbref = FirebaseDatabase.getInstance().getReference();;
        // So I will write a helper function to add to database at the worst case
//        Checkout obj = new Checkout();
//        obj.updateDB();
        // Update DB has been sucessfully updated

    }
}