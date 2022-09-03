package com.ppe.pppgateway.indivisual_payments_classes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ppe.pppgateway.R;
import com.ppe.pppgateway.SMS_Twilio;

import java.util.concurrent.atomic.AtomicReference;

public class NetBankingBottomSheet extends BottomSheetDialogFragment {
    View parent;
    EditText tx_id;
    Button tx_recipt,net_banking_submit;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parent = inflater.inflate(R.layout.net_banking_bottom_sheet,
                container, false);

        return parent;
    }
    public void init(){
        tx_id = parent.findViewById(R.id.tx_id);
        tx_recipt=parent.findViewById(R.id.upload_tx_recipt);
        net_banking_submit = parent.findViewById(R.id.net_banking_submit);

        tx_recipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // implement a file picker here :
                Toast.makeText(getActivity(), "Under construction...", Toast.LENGTH_SHORT).show();
            }
        });

        net_banking_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AtomicReference<Boolean> res = AlertBoxOpener();
                tx_id.setText("");
            }
        });

    }
    public AtomicReference<Boolean> AlertBoxOpener(){
        AtomicReference<Boolean> response = new AtomicReference<>(false);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage("As testing, you want TX to be successful or failed??");
        builder.setTitle("Select Action!");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", (DialogInterface.OnClickListener) (dialog, which) -> {
            Toast.makeText(getActivity(), "Payment Success", Toast.LENGTH_SHORT).show();
            response.set(true);
            SMS_Twilio.sendMessage(SMS_Twilio.SUCCESS_MESSAGE);
            dialog.cancel();
        });

        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            Toast.makeText(getActivity(), "Payment Failed", Toast.LENGTH_SHORT).show();
            response.set(false);
            SMS_Twilio.sendMessage(SMS_Twilio.FAILURE_MESSAGE);
            dialog.cancel();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        return response;
    }
}
