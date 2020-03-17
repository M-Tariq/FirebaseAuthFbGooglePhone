package com.figuredin.firebaseauthfbgooglephone;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1234){
            if(resultCode==RESULT_OK){
                Toast.makeText(this, "Signin Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, HomeActivity.class));
            }
        }else {
            Toast.makeText(this, "Signin Failled", Toast.LENGTH_SHORT).show();
        }
    }

    public void signInClick(View view) {

        List<AuthUI.IdpConfig> providers;
        providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build(),
                        new AuthUI.IdpConfig.PhoneBuilder().build(),
                new AuthUI.IdpConfig.GoogleBuilder().build()
                        );
        startActivityForResult(AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .build(),
                1234);
    }

    public void signOutClick(View view) {
    }
}
