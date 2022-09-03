package com.ppe.pppgateway.indivisual_payments_classes;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.ppe.pppgateway.R;

import java.util.concurrent.atomic.AtomicReference;

public class UPI_bottom_sheet extends BottomSheetDialogFragment {
    View parent;
    Button upi_pay;
    EditText upi_id, upi_pin;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parent = inflater.inflate(R.layout.upi_bottom_sheet,
                container, false);
        init();

        return parent;
    }
    public void init(){
        upi_id = parent.findViewById(R.id.upi_id);
        upi_pin =parent.findViewById(R.id.upi_pin);
        upi_pay = parent.findViewById(R.id.pay_upi);
        upi_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    AtomicReference<Boolean> response = AlertBoxOpener();
                    upi_id.setText("");
                    upi_pin.setText("");
                }catch (Exception e){
                    Log.d("AlertBpx",e.getMessage());
                }

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
            dialog.cancel();
        });

        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            Toast.makeText(getActivity(), "Payment Failed", Toast.LENGTH_SHORT).show();
            response.set(false);
            dialog.cancel();
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        return response;
    }
}
