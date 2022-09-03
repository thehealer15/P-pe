package com.ppe.pppgateway;

import android.util.Base64;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public class SMS_Twilio {
    public static void sendMessage( String body) {

        final String ACCOUNT_SID = ParityData.ACCOUNT_SID;
        final String AUTH_TOKEN = ParityData.AUTH_TOKEN;

        String from = ParityData.Sender;
        String to = ParityData.AkshayPawar;

        String base64EncodedCredentials = "Basic " + Base64.encodeToString(
                (ACCOUNT_SID + ":" + AUTH_TOKEN).getBytes(), Base64.NO_WRAP
        );

        Map<String, String> data = new HashMap<>();
        data.put("From", from);
        data.put("To", to);
        data.put("Body", body);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.twilio.com/2010-04-01/")
                .build();
        TwilioApi api = retrofit.create(TwilioApi.class);

        api.sendMessage(ACCOUNT_SID, base64EncodedCredentials, data).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) Log.d("TAG", "onResponse->success");
                else Log.d("TAG", "onResponse->failure");
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d("TAG", "onFailure");
            }
        });
    }
    interface TwilioApi {
        @FormUrlEncoded
        @POST("Accounts/{ACCOUNT_SID}/SMS/Messages")
        Call<ResponseBody> sendMessage(
                @Path("ACCOUNT_SID") String accountSId,
                @Header("Authorization") String signature,
                @FieldMap Map<String, String> smsdata
        );
    }

    // messages
    public static String FAILURE_MESSAGE = "Hi, this is to inform you, there is payment failure During a transaction via P-pe, we regret in-convenience";
    public static String SUCCESS_MESSAGE= "Hi, this is to inform you, there is payment made to your business via P-pe";

}
