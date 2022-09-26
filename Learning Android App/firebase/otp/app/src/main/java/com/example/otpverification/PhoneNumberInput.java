package com.example.otpverification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.example.otpverification.databinding.ActivityPhoneNumberInputBinding;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class PhoneNumberInput extends AppCompatActivity {

    //this will help to connect the root file with java file and due to which we didn't have to
//use the findViewByid

    private ActivityPhoneNumberInputBinding binding;
    private FirebaseAuth auth;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks callBacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number_input);
//        here is the complete code
        binding = ActivityPhoneNumberInputBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle("Number dal na!!");

        auth = FirebaseAuth.getInstance();

        binding.otpSend.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (binding.phoneNumber.getText().toString().trim().isEmpty() ||
                        binding.phoneNumber.getText().toString().trim().length() != 10
                ) {
                    Toast.makeText(PhoneNumberInput.this, "Enter the correct number!", Toast.LENGTH_SHORT).show();
                } else {
                    binding.progressBar.setVisibility(View.VISIBLE);
                    binding.otpSend.setVisibility(View.GONE);
                    otpSend();

                }
            }
        });

    }

        private void otpSend() {


            callBacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                @Override
                public void onVerificationCompleted(PhoneAuthCredential credential) {

                }

                @Override
                public void onVerificationFailed(FirebaseException e) {
    //for any of the reason the otp could not sent to the user
    //            and for that we will use this method
    //            to give any message
                    binding.progressBar.setVisibility(View.GONE);
                    binding.otpSend.setVisibility(View.VISIBLE);
                    Toast.makeText(PhoneNumberInput.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                    Log.d("temp", e.getLocalizedMessage());
                }

                @Override
                public void onCodeSent(@NonNull String verificationId,
                                       @NonNull PhoneAuthProvider.ForceResendingToken token) {
    //here we will call the intent where we will match the verificationId and the otp
                    binding.progressBar.setVisibility(View.GONE);
                    binding.otpSend.setVisibility(View.VISIBLE);
                    Toast.makeText(PhoneNumberInput.this, "Otp sent successfully!!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(PhoneNumberInput.this, OtpVerification.class);
                    intent.putExtra("verificationId", verificationId);
                    startActivity(intent);
                }
            };


    //        all these code are help to send the otp to the user and after sending the otp we will look after the callBacks
    //for next step

            PhoneAuthOptions options =
                    PhoneAuthOptions.newBuilder(auth)
                            .setPhoneNumber("+91" + binding.phoneNumber.getText().toString().trim())       // Phone number to verify
                            .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                            .setActivity(this)                 // Activity (for callback binding)
                            .setCallbacks(callBacks)          // OnVerificationStateChangedCallbacks
                            .build();
            PhoneAuthProvider.verifyPhoneNumber(options);
        }


}