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

public class CardBottomSheet extends BottomSheetDialogFragment {
    View parent;
    EditText card_number, card_cvv;
    Button submit_details;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         parent = inflater.inflate(R.layout.card_bottom_sheet,
                container, false);
        init();
        submit_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    AtomicReference<Boolean> response = AlertBoxOpener();
                    card_number.setText("");
                    card_cvv.setText("");
                }catch (Exception e){
                    Log.d("alertBox",e.getMessage());
                }
            }
        });
         return parent;
    }
    private void init(){
        card_cvv = parent.findViewById(R.id.card_cvv_number);
        card_number = parent.findViewById(R.id.card_number);
        submit_details = parent.findViewById(R.id.submit_card_details);
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
    public void updateToDB(){
        String API_KEY = API_KEY_C.API_KEY;
        
    }
}
