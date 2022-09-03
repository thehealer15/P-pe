package com.ppe.pppgateway.indivisual_payments_classes;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ppe.pppgateway.R;
import com.ppe.pppgateway.SMS_Twilio;

public class E_WalletsBottomSheet extends BottomSheetDialogFragment {
    View parent;
    Button phonePay, payTm;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parent = inflater.inflate(R.layout.ewallet_bottom_sheet,
                container, false);
        phonePay = parent.findViewById(R.id.phone_paywallet);
        payTm = parent.findViewById(R.id.paytm_wallet);

        phonePay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SMS_Twilio.sendMessage("TRANSACTIONS VIA E-WALLETS ARE UNDER CONSTRUCTION, SO TX FAILED");
                openApp(getContext() , "com.phonepe.app");
            }
        });
        payTm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SMS_Twilio.sendMessage("TRANSACTIONS VIA E-WALLETS ARE UNDER CONSTRUCTION, SO TX FAILED");
                openApp(getContext(), "net.one97.paytm");
            }
        });
        return parent;
    }
    public boolean openApp(Context context, String PackageName){
        PackageManager manager = context.getPackageManager();
        try{
            Intent i = manager.getLaunchIntentForPackage(PackageName);
            if(i == null ){
                Toast.makeText(context, "ATTEMPT TO OPEN PAYMENT APP", Toast.LENGTH_SHORT).show();
                return false;
            }
            i.addCategory(Intent.CATEGORY_LAUNCHER);
            context.startActivity(i);
            return true;
        }
        catch (Exception e){
            Toast.makeText(getActivity(), "something went wrong", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
